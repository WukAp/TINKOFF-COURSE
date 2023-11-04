package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static edu.hw4.Animal.Type.CAT;
import static edu.hw4.Animal.Type.DOG;
import static edu.hw4.Animal.Type.FISH;
import static edu.hw4.AnimalBuilder.createAnimalByWeightType;

public class Task18Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getTheHeaviestFish() {

        Assertions.assertEquals(
            createAnimalByWeightType(10, FISH),
            animalUtils.getTheHeaviestFish(List.of(
                createAnimalByWeightType(5, FISH),
                createAnimalByWeightType(10, FISH),
                createAnimalByWeightType(100, CAT),
                createAnimalByWeightType(2, FISH)
            ))
        );
        Assertions.assertEquals(
            createAnimalByWeightType(10, FISH),
            animalUtils.getTheHeaviestFish(List.of(
                createAnimalByWeightType(5, FISH),
                createAnimalByWeightType(10, FISH)
            ), List.of(
                createAnimalByWeightType(3, FISH),
                createAnimalByWeightType(2, CAT),
                createAnimalByWeightType(20, CAT)
            ), List.of(
                createAnimalByWeightType(30, DOG),
                createAnimalByWeightType(2, FISH)
            ))
        );
    }

    @Test
    void getTheHeaviestFishExceptions() {
        Assertions.assertThrows(
            NoSuchElementException.class, () ->
                animalUtils.getTheHeaviestFish(List.of())
        );
        Assertions.assertThrows(
            NoSuchElementException.class, () ->
                animalUtils.getTheHeaviestFish(List.of(
                    createAnimalByWeightType(5, CAT),
                    createAnimalByWeightType(10, CAT)
                ), List.of(
                    createAnimalByWeightType(3, CAT),
                    createAnimalByWeightType(2, CAT)
                ))
        );
        Assertions.assertThrows(
            NullPointerException.class,
            () -> animalUtils.getTheHeaviestFish(null)
        );
    }

}
