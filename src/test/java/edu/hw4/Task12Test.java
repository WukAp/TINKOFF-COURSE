package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalBuilder.createAnimalByHeightBites;
import static edu.hw4.AnimalBuilder.createAnimalByWeightHeight;

public class Task12Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getAnimalsWithWeightMoreThenHeight() {
        Assertions.assertEquals(3, animalUtils.getAnimalsWithWeightMoreThenHeight(List.of(
            createAnimalByWeightHeight(10, 10),
            createAnimalByWeightHeight(11, 10),
            createAnimalByWeightHeight(10, 11),
            createAnimalByWeightHeight(14, 10),
            createAnimalByWeightHeight(10, 11),
            createAnimalByWeightHeight(100, 10)
        )));

        Assertions.assertEquals(3, animalUtils.getAnimalsWithWeightMoreThenHeight(List.of(
            createAnimalByWeightHeight(11, 10),
            createAnimalByWeightHeight(100, 10),
            createAnimalByWeightHeight(14, 10)
        )));
        Assertions.assertEquals(
            0,
            animalUtils.getAnimalsWithWeightMoreThenHeight(List.of(
                createAnimalByWeightHeight(10, 10),
                createAnimalByWeightHeight(10, 11),
                createAnimalByWeightHeight(10, 11)
            ))
        );
        Assertions.assertEquals(0, animalUtils.getAnimalsWithWeightMoreThenHeight(List.of()));
    }

    @Test
    void getAnimalsWithWeightMoreThenHeightExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.getAnimalsWithWeightMoreThenHeight(null)
        );
    }
}
