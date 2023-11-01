package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.SPIDER;
import static edu.hw4.AnimalBuilder.createAnimalByTypeBites;

public class Task17Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void isSpidersBiteMoreThenDogs() {
        Assertions.assertTrue(animalUtils.isSpidersBiteMoreThenDogs(List.of(
            createAnimalByTypeBites(CAT, true),
            createAnimalByTypeBites(CAT, true),
            createAnimalByTypeBites(DOG, true),
            createAnimalByTypeBites(DOG, false),
            createAnimalByTypeBites(DOG, false),
            createAnimalByTypeBites(SPIDER, true),
            createAnimalByTypeBites(SPIDER, true)
        )));
        Assertions.assertTrue(animalUtils.isSpidersBiteMoreThenDogs(List.of(
            createAnimalByTypeBites(CAT, true),
            createAnimalByTypeBites(CAT, true),
            createAnimalByTypeBites(SPIDER, true),
            createAnimalByTypeBites(SPIDER, true)
        )));
        Assertions.assertFalse(animalUtils.isSpidersBiteMoreThenDogs(List.of(
            createAnimalByTypeBites(DOG, true),
            createAnimalByTypeBites(CAT, true),
            createAnimalByTypeBites(DOG, true),
            createAnimalByTypeBites(DOG, false),
            createAnimalByTypeBites(DOG, false),
            createAnimalByTypeBites(SPIDER, true),
            createAnimalByTypeBites(SPIDER, true)
        )));
        Assertions.assertFalse(animalUtils.isSpidersBiteMoreThenDogs(List.of(
            createAnimalByTypeBites(CAT, true),
            createAnimalByTypeBites(DOG, true),
            createAnimalByTypeBites(DOG, true),
            createAnimalByTypeBites(DOG, false),
            createAnimalByTypeBites(DOG, false),
            createAnimalByTypeBites(SPIDER, true),
            createAnimalByTypeBites(SPIDER, false)
        )));
        Assertions.assertFalse(animalUtils.isSpidersBiteMoreThenDogs(List.of()));
        Assertions.assertFalse(animalUtils.isSpidersBiteMoreThenDogs(null));
    }
}
