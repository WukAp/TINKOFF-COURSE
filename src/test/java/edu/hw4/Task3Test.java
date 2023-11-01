package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.AnimalBuilder.createAnimalByType;

public class Task3Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getFrequencyListOfAnimals() {
        var frequencyListOfAnimals = animalUtils.getFrequencyListOfAnimals(List.of(
            createAnimalByType(DOG),
            createAnimalByType(DOG),
            createAnimalByType(FISH),
            createAnimalByType(FISH),
            createAnimalByType(CAT),
            createAnimalByType(DOG),
            createAnimalByType(BIRD),
            createAnimalByType(DOG),
            createAnimalByType(DOG),
            createAnimalByType(CAT),
            createAnimalByType(BIRD),
            createAnimalByType(BIRD),
            createAnimalByType(CAT)
        ));
        Assertions.assertEquals(4, frequencyListOfAnimals.size());
        Assertions.assertEquals(2, frequencyListOfAnimals.get(FISH));
        Assertions.assertEquals(3, frequencyListOfAnimals.get(BIRD));
        Assertions.assertEquals(5, frequencyListOfAnimals.get(DOG));
        Assertions.assertEquals(3, frequencyListOfAnimals.get(CAT));
        Assertions.assertNull(frequencyListOfAnimals.get(SPIDER));
        Assertions.assertDoesNotThrow(() -> animalUtils.getFrequencyListOfAnimals(List.of()));
    }

    @Test
    void getFrequencyListOfAnimalsExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalUtils.getFrequencyListOfAnimals(null));
    }
}
