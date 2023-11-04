package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalBuilder.createAnimalByAge;
import static edu.hw4.AnimalBuilder.createAnimalByWeightHeight;

public class Task8Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getTheHeaviestFromAnimalsShorterThenK() {
        Assertions.assertEquals(
            createAnimalByWeightHeight(100, 10),
            animalUtils.getTheHeaviestFromAnimalsShorterThenK(List.of(
                createAnimalByWeightHeight(10, 10),
                createAnimalByWeightHeight(15, 10),
                createAnimalByWeightHeight(100, 10),
                createAnimalByWeightHeight(10, 100),
                createAnimalByWeightHeight(15, 100),
                createAnimalByWeightHeight(100, 100)
            ), 20).orElseThrow()
        );
        Assertions.assertFalse(
            animalUtils.getTheHeaviestFromAnimalsShorterThenK(List.of(
                createAnimalByWeightHeight(10, 10),
                createAnimalByWeightHeight(15, 10),
                createAnimalByWeightHeight(100, 10),
                createAnimalByWeightHeight(10, 100),
                createAnimalByWeightHeight(15, 100),
                createAnimalByWeightHeight(100, 100)
            ), 10).isPresent()
        );
        Assertions.assertFalse(animalUtils.getTheHeaviestFromAnimalsShorterThenK(List.of(), 20).isPresent());
    }

    @Test
    void getTheHeaviestFromAnimalsShorterThenKExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.getTheHeaviestFromAnimalsShorterThenK(null, 10)
        );
    }

}
