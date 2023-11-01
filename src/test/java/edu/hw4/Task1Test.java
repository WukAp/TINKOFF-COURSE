package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalBuilder.createAnimalByHeight;

public class Task1Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getSortedByHeight() {
        Assertions.assertArrayEquals(
            new Animal[] {createAnimalByHeight(3), createAnimalByHeight(20), createAnimalByHeight(100),
                createAnimalByHeight(150),
                createAnimalByHeight(300)},
            animalUtils.getSortedByHeight(List.of(
                createAnimalByHeight(100),
                createAnimalByHeight(150),
                createAnimalByHeight(3),
                createAnimalByHeight(300),
                createAnimalByHeight(20)
            )).toArray()
        );
        Assertions.assertArrayEquals(
            new Animal[] {},
            animalUtils.getSortedByHeight(List.of()).toArray()
        );
    }

    @Test
    void getSortedByHeightExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalUtils.getSortedByHeight(null));
    }

}
