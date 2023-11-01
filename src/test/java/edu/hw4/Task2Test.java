package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalBuilder.createAnimalByWeight;

public class Task2Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getTheHeaviestAnimalsLimited() {
        Assertions.assertArrayEquals(
            new Animal[] {createAnimalByWeight(200), createAnimalByWeight(100), createAnimalByWeight(25)},
            animalUtils.getTheHeaviestAnimalsLimited(List.of(
                createAnimalByWeight(200),
                createAnimalByWeight(20),
                createAnimalByWeight(2),
                createAnimalByWeight(100),
                createAnimalByWeight(20),
                createAnimalByWeight(25)
            ), 3).toArray()
        );
        Assertions.assertArrayEquals(
            new Animal[] {},
            animalUtils.getTheHeaviestAnimalsLimited(List.of(), 10).toArray()
        );
    }

    @Test
    void getTheHeaviestAnimalsLimitedExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.getTheHeaviestAnimalsLimited(null, 2)
        );
    }
}
