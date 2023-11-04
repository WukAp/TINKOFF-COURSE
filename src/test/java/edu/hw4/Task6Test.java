package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.AnimalBuilder.createAnimalByWeightType;

public class Task6Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getTheHeaviestAnimalOfTypes() {
        var heaviestAnimalOfTypes = animalUtils.getTheHeaviestAnimalOfTypes(List.of(
            createAnimalByWeightType(10, DOG),
            createAnimalByWeightType(5, DOG),
            createAnimalByWeightType(20, DOG),
            createAnimalByWeightType(60, DOG),
            createAnimalByWeightType(100, DOG),
            createAnimalByWeightType(10, FISH),
            createAnimalByWeightType(5, FISH),
            createAnimalByWeightType(5, CAT),
            createAnimalByWeightType(10, CAT),
            createAnimalByWeightType(2, CAT),
            createAnimalByWeightType(1, BIRD),
            createAnimalByWeightType(20, BIRD),
            createAnimalByWeightType(3, BIRD)
        ));
        Assertions.assertEquals(4, heaviestAnimalOfTypes.size());
        Assertions.assertEquals(
            createAnimalByWeightType(10, FISH),
            heaviestAnimalOfTypes.get(FISH)
        );
        Assertions.assertEquals(
            createAnimalByWeightType(20, BIRD),
            heaviestAnimalOfTypes.get(BIRD)
        );
        Assertions.assertEquals(
            createAnimalByWeightType(100, DOG),
            heaviestAnimalOfTypes.get(DOG)
        );
        Assertions.assertEquals(
            createAnimalByWeightType(10, CAT),
            heaviestAnimalOfTypes.get(CAT)
        );
        Assertions.assertNull(heaviestAnimalOfTypes.get(SPIDER));
        Assertions.assertDoesNotThrow(() -> animalUtils.getFrequencyListOfAnimals(List.of()));
    }

    @Test
    void getTheHeaviestAnimalOfTypesExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalUtils.getTheHeaviestAnimalOfTypes(null));
    }
}
