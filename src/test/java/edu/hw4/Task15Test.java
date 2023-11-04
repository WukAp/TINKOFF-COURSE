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
import static edu.hw4.AnimalBuilder.createAnimalByWeightType;
import static edu.hw4.AnimalBuilder.createAnimalByWeightTypeAge;

public class Task15Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getSumOfWeightOfTypesInAgeRange() {
        var sumOfWeightOfTypesInAgeRange = animalUtils.getSumOfWeightOfTypesInAgeRange(List.of(
            createAnimalByWeightTypeAge(10, DOG, 5),
            createAnimalByWeightTypeAge(5, DOG, 6),
            createAnimalByWeightTypeAge(10, DOG, 10),
            createAnimalByWeightTypeAge(100, DOG, 2),
            createAnimalByWeightTypeAge(2, FISH, 7),
            createAnimalByWeightTypeAge(3, FISH, 10),
            createAnimalByWeightTypeAge(10, CAT, 10),
            createAnimalByWeightTypeAge(15, CAT, 8),
            createAnimalByWeightTypeAge(5, CAT, 5),
            createAnimalByWeightTypeAge(10, BIRD, 6),
            createAnimalByWeightTypeAge(4, BIRD, 5),
            createAnimalByWeightTypeAge(1, BIRD, 5)
        ), 5, 7);
        Assertions.assertEquals(4, sumOfWeightOfTypesInAgeRange.size());
        Assertions.assertEquals(2, sumOfWeightOfTypesInAgeRange.get(FISH));
        Assertions.assertEquals(15, sumOfWeightOfTypesInAgeRange.get(BIRD));
        Assertions.assertEquals(15, sumOfWeightOfTypesInAgeRange.get(DOG));
        Assertions.assertEquals(5, sumOfWeightOfTypesInAgeRange.get(CAT));
        Assertions.assertNull(sumOfWeightOfTypesInAgeRange.get(SPIDER));
        Assertions.assertDoesNotThrow(() -> animalUtils.getFrequencyListOfAnimals(List.of()));
    }

    @Test
    void getSumOfWeightOfTypesInAgeRangeExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.getSumOfWeightOfTypesInAgeRange(null, 0, 10)
        );
    }
}
