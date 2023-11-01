package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Sex.M;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.AnimalBuilder.createAnimalByTypeNameSex;

public class Task16Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getSortedByTypeThenSexThenName() {

        Assertions.assertArrayEquals(
            new Animal[] {createAnimalByTypeNameSex(CAT, "Fed", M), createAnimalByTypeNameSex(DOG, "Fed", M),
                createAnimalByTypeNameSex(BIRD, "Bob", M),
                createAnimalByTypeNameSex(BIRD, "Fed", M), createAnimalByTypeNameSex(BIRD, "Fed", F)},
            animalUtils.getSortedByTypeThenSexThenName(List.of(
                createAnimalByTypeNameSex(DOG, "Fed", M),
                createAnimalByTypeNameSex(BIRD, "Fed", M),
                createAnimalByTypeNameSex(BIRD, "Fed", F),
                createAnimalByTypeNameSex(BIRD, "Bob", M),
                createAnimalByTypeNameSex(CAT, "Fed", M)
            )).toArray()
        );
        Assertions.assertArrayEquals(
            new Animal[] {},
            animalUtils.getSortedByTypeThenSexThenName(List.of()).toArray()
        );
    }

    @Test
    void getSortedByTypeThenSexThenNameExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.getSortedByTypeThenSexThenName(null)
        );
    }
}
