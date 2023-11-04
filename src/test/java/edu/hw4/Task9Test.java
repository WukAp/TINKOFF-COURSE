package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.AnimalBuilder.createAnimalByType;

public class Task9Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getSumOfPaws() {
        Assertions.assertEquals(14, animalUtils.getSumOfPaws(List.of(
            createAnimalByType(DOG),
            createAnimalByType(FISH),
            createAnimalByType(FISH),
            createAnimalByType(CAT),
            createAnimalByType(DOG),
            createAnimalByType(BIRD)
        )));
        Assertions.assertEquals(0, animalUtils.getSumOfPaws(List.of(
            createAnimalByType(FISH),
            createAnimalByType(FISH)
        )));
        Assertions.assertEquals(0, animalUtils.getSumOfPaws(List.of()));
    }

    @Test
    void getSumOfPawsExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> animalUtils.getSumOfPaws(null));
    }
}
