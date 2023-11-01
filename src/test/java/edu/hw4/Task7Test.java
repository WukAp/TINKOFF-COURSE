package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalBuilder.createAnimalByAge;
import static edu.hw4.AnimalBuilder.createAnimalByName;

public class Task7Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getKthOldestAnimal() {

        Assertions.assertEquals(createAnimalByAge(4), animalUtils.getKthOldestAnimal(List.of(
            createAnimalByAge(5),
            createAnimalByAge(6),
            createAnimalByAge(1),
            createAnimalByAge(4),
            createAnimalByAge(3)
        ), 3));
    }

    @Test
    void getKthOldestAnimalExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalUtils.getKthOldestAnimal(List.of(), 3));
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalUtils.getKthOldestAnimal(null, 3));
    }
}
