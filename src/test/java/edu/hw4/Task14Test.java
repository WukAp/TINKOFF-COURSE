package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.AnimalBuilder.createAnimalByHeightType;
import static edu.hw4.AnimalBuilder.createAnimalByWeightType;

public class Task14Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void containsDogHigherThenInfimumHeight() {
        Assertions.assertTrue(animalUtils.containsDogHigherThenInfimumHeight(
            List.of(
                createAnimalByHeightType(5, DOG),
                createAnimalByHeightType(15, DOG),
                createAnimalByHeightType(5, DOG)
            ), 10));
        Assertions.assertTrue(animalUtils.containsDogHigherThenInfimumHeight(
            List.of(createAnimalByHeightType(5, DOG)),
            0
        ));
        Assertions.assertFalse(animalUtils.containsDogHigherThenInfimumHeight(List.of(createAnimalByHeightType(
            10,
            DOG
        )), 100));
        Assertions.assertFalse(animalUtils.containsDogHigherThenInfimumHeight(List.of(
            createAnimalByHeightType(50, DOG),
            createAnimalByHeightType(15, DOG),
            createAnimalByHeightType(5, DOG)
        ), 50));
        Assertions.assertFalse(animalUtils.containsDogHigherThenInfimumHeight(List.of(), 10));
        Assertions.assertFalse(animalUtils.containsDogHigherThenInfimumHeight(List.of(), 0));
    }

    @Test
    void containsDogHigherThenInfimumHeightExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.containsDogHigherThenInfimumHeight(null, 10)
        );
    }
}
