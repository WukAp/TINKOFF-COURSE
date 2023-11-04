package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static edu.hw4.AnimalBuilder.createAnimalBySex;

public class Task5Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getTheMostNumerousSex() {
        Assertions.assertEquals(F, animalUtils.getTheMostNumerousSex(List.of(
                createAnimalBySex(F),
                createAnimalBySex(F),
                createAnimalBySex(M),
                createAnimalBySex(F),
                createAnimalBySex(F),
                createAnimalBySex(M),
                createAnimalBySex(M)
            ))
        );
        Assertions.assertEquals(M, animalUtils.getTheMostNumerousSex(List.of(
                createAnimalBySex(F),
                createAnimalBySex(F),
                createAnimalBySex(M),
                createAnimalBySex(F),
                createAnimalBySex(M),
                createAnimalBySex(M),
                createAnimalBySex(M)
            ))
        );
    }

    @Test
    void getTheMostNumerousSexExceptions() {
        Assertions.assertThrows(
            NoSuchElementException.class,
            () -> animalUtils.getTheMostNumerousSex(List.of())
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalUtils.getTheMostNumerousSex(null));
    }
}
