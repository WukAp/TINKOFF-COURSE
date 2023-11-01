package edu.hw4;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;

public class AnimalUtils {

    public List<Animal> getSortedByHeight(@NotNull List<Animal> animalList) {
        return animalList.stream().sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    public List<Animal> getTheHeaviestAnimalsLimited(@NotNull List<Animal> animalList, int listSizeLimit) {
        return animalList.stream().sorted((animal1, animal2) -> -Integer.compare(animal1.weight(), animal2.weight()))
            .limit(listSizeLimit)
            .toList();
    }

    public Map<Animal.Type, Long> getFrequencyListOfAnimals(@NotNull List<Animal> animalList) {
        return animalList.stream().collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    public Animal getAnimalWithTheLongestName(@NotNull List<Animal> animalList) {
        validateNotNull(animalList);
        return animalList.stream().max(Comparator.comparingInt(animal -> animal.name().length())).orElseThrow();
    }

    public Animal.Sex getTheMostNumerousSex(@NotNull List<Animal> animalList) {
        validateNotNull(animalList);
        return Collections.max(animalList.stream().collect(Collectors.groupingBy(Animal::sex, Collectors.counting()))
            .entrySet(), Comparator.comparingLong(Map.Entry::getValue)).getKey();
    }

    public Map<Animal.Type, Animal> getTheHeaviestAnimalOfTypes(@NotNull List<Animal> animalList) {
        return animalList.stream()
            .collect(Collectors.toMap(
                Animal::type,
                val -> val,
                (animal1, animal2) -> animal1.weight() > animal2.weight() ? animal1 : animal2
            ));
    }

    public Animal getKthOldestAnimal(@NotNull List<Animal> animalList, int k) {
        validateNotNull(animalList);
        return animalList.stream().sorted((animal1, animal2) -> -Integer.compare(animal1.age(), animal2.age()))
            .skip(k - 1).findFirst()
            .orElseThrow();
    }

    public Optional<Animal> getTheHeaviestFromAnimalsShorterThenK(@NotNull List<Animal> animalList, int k) {
        return animalList.stream().filter(animal -> animal.height() < k).max(Comparator.comparingInt(Animal::weight));
    }

    public int getSumOfPaws(@NotNull List<Animal> animalList) {

        return animalList.stream().reduce(0, (paws, animal) -> paws + animal.paws(), Integer::sum);
    }

    public List<Animal> getAnimalsWithPawsAmountNotEqualsAge(@NotNull List<Animal> animalList) {

        return animalList.stream().filter(animal -> animal.paws() != animal.age()).toList();
    }

    public List<Animal> getBitingAnimalsTallerThan100(@NotNull List<Animal> animalList) {
        final int infimumHeight = 100;
        return animalList.stream().filter(animal -> animal.height() > infimumHeight && animal.bites()).toList();
    }

    public long getAnimalsWithWeightMoreThenHeight(@NotNull List<Animal> animalList) {
        return animalList.stream().filter(animal -> animal.weight() > animal.height()).count();
    }

    public List<Animal> getAnimalsWithNameOfMoreThenOneWord(@NotNull List<Animal> animalList) {
        return animalList.stream().filter(animal -> animal.name().contains(" ")).toList();
    }

    public boolean containsDogHigherThenInfimumHeight(@NotNull List<Animal> animalList, int infimumHeight) {
        return animalList.stream()
            .anyMatch((animal) -> animal.type() == Animal.Type.DOG && animal.height() > infimumHeight);
    }

    public Map<Animal.Type, Integer> getSumOfWeightOfTypesInAgeRange(
        @NotNull List<Animal> animalList,
        int minAge,
        int maxAge
    ) {
        return animalList.stream().filter((animal) -> animal.age() >= minAge && animal.age() <= maxAge)
            .collect(Collectors.toMap(Animal::type, Animal::weight, Integer::sum));
    }

    public List<Animal> getSortedByTypeThenSexThenName(@NotNull List<Animal> animalList) {
        return animalList.stream().sorted((animal1, animal2) -> {
            if (!animal1.type().equals(animal2.type())) {
                return animal1.type().compareTo(animal2.type());
            }
            if (!animal1.sex().equals(animal2.sex())) {
                return animal1.sex().compareTo(animal2.sex());
            }
            return animal1.name().compareTo(animal2.name());
        }).toList();
    }

    public boolean isSpidersBiteMoreThenDogs(List<Animal> animalList) {
        return animalList != null
            && bitingsInTypeCounter(animalList, Animal.Type.SPIDER) > bitingsInTypeCounter(animalList, Animal.Type.DOG);
    }

    @SafeVarargs public final Animal getTheHeaviestFish(List<Animal>... animalLists) {
        return Arrays.stream(animalLists).flatMap(List::stream)
            .filter((animal) -> animal.type().equals(Animal.Type.FISH)).max(Comparator.comparingInt(Animal::weight))
            .orElseThrow();
    }

    public Map<String, Set<ValidationError>> getIncorrectAnimals(List<Animal> animalList) {
        return animalList.stream().map(animal -> new AbstractMap.SimpleEntry<>(animal.name(), getErrors(animal)))
            .filter(entry -> entry.getValue() != null && !entry.getValue().isEmpty())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, String> getPrettyPrintIncorrectAnimals(List<Animal> animalList) {
        return animalList.stream()
            .map(animal -> new AbstractMap.SimpleEntry<>(animal.name(), getErrors(animal).toString()
            )).filter(entry -> entry.getValue() != null && !entry.getValue().equals(List.of().toString()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private void validateNotNull(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            throw new IllegalArgumentException("input list shouldn't be empty");
        }
    }

    private long bitingsInTypeCounter(@NotNull List<Animal> animalList, Animal.Type type) {
        return animalList.stream().filter((animal) -> animal
            .type() == type && animal.bites()).count();
    }

    private Set<ValidationError> getErrors(Animal animal) {
        Set<ValidationError> errors = new HashSet<>();
        if (animal.name() == null) {
            errors.add(new ValidationError.NullPointerNameException());
        }
        if (animal.type() == null) {
            errors.add(new ValidationError.NullPointerTypeException());
        }
        if (animal.sex() == null) {
            errors.add(new ValidationError.NullPointerSexException());
        }
        if (animal.weight() < 0) {
            errors.add(new ValidationError.IllegalWeightArgumentException());
        }
        if (animal.height() < 0) {
            errors.add(new ValidationError.IllegalHeightArgumentException());
        }
        if (animal.age() < 0) {
            errors.add(new ValidationError.IllegalAgeArgumentException());
        }
        return errors;
    }
}
