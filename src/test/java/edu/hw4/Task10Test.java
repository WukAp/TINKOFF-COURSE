package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.AnimalBuilder.createAnimalByAgeType;

public class Task10Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getAnimalsWithPawsAmountNotEqualsAge() {
        var animalsWithPawsAmountNotEqualsAge = animalUtils.getAnimalsWithPawsAmountNotEqualsAge(List.of(
            createAnimalByAgeType(3, DOG),
            createAnimalByAgeType(4, DOG),
            createAnimalByAgeType(2, FISH),
            createAnimalByAgeType(4, CAT),
            createAnimalByAgeType(10, CAT),
            createAnimalByAgeType(2, BIRD),
            createAnimalByAgeType(8, SPIDER)
        ));
        Assertions.assertEquals(3, animalsWithPawsAmountNotEqualsAge.size());
        Assertions.assertTrue(animalsWithPawsAmountNotEqualsAge.contains(createAnimalByAgeType(3, DOG)));
        Assertions.assertTrue(animalsWithPawsAmountNotEqualsAge.contains(createAnimalByAgeType(2, FISH)));
        Assertions.assertTrue(animalsWithPawsAmountNotEqualsAge.contains(createAnimalByAgeType(10, CAT)));

        Assertions.assertTrue(animalUtils.getAnimalsWithPawsAmountNotEqualsAge(List.of()).isEmpty());
    }

    @Test
    void getAnimalsWithPawsAmountNotEqualsAgeExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.getAnimalsWithPawsAmountNotEqualsAge(null)
        );
    }
}
