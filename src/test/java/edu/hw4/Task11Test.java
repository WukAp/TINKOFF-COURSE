package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.AnimalBuilder.createAnimalByAgeType;
import static edu.hw4.AnimalBuilder.createAnimalByHeightBites;
import static edu.hw4.AnimalBuilder.createAnimalByWeight;

public class Task11Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getBitingAnimalsTallerThan100() {
        var bitingAnimalsTallerThan100 = animalUtils.getBitingAnimalsTallerThan100(List.of(
            createAnimalByHeightBites(101, true),
            createAnimalByHeightBites(10, true),
            createAnimalByHeightBites(101, false),
            createAnimalByHeightBites(150, true),
            createAnimalByHeightBites(100, true),
            createAnimalByHeightBites(200, true)
        ));
        Assertions.assertEquals(3, bitingAnimalsTallerThan100.size());
        Assertions.assertTrue(bitingAnimalsTallerThan100.contains(createAnimalByHeightBites(101, true)));
        Assertions.assertTrue(bitingAnimalsTallerThan100.contains(createAnimalByHeightBites(150, true)));
        Assertions.assertTrue(bitingAnimalsTallerThan100.contains(createAnimalByHeightBites(200, true)));
        Assertions.assertTrue(animalUtils.getBitingAnimalsTallerThan100(List.of()).isEmpty());
    }

    @Test
    void getBitingAnimalsTallerThan100Exceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.getBitingAnimalsTallerThan100(null)
        );
    }
}
