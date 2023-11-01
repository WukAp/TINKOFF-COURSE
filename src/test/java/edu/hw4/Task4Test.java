package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalBuilder.createAnimalByName;

public class Task4Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getTheLongestAnimalName() {
        Assertions.assertEquals(createAnimalByName("Sausage"), animalUtils.getAnimalWithTheLongestName(List.of(
            createAnimalByName("Melya"),
            createAnimalByName("Sausage"),
            createAnimalByName("Pupa"),
            createAnimalByName("Pelmen"),
            createAnimalByName("Kot")
        )));
    }

    @Test
    void getTheLongestAnimalNameExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.getAnimalWithTheLongestName(List.of())
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalUtils.getAnimalWithTheLongestName(null));
    }
}
