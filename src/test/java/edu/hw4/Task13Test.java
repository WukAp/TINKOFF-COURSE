package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.AnimalBuilder.createAnimalByHeightBites;
import static edu.hw4.AnimalBuilder.createAnimalByName;

public class Task13Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getAnimalsWithNameOfMoreThenOneWord() {
        var animalsWithNameOfMoreThenOneWord = animalUtils.getAnimalsWithNameOfMoreThenOneWord(List.of(
            createAnimalByName("Sweet Cat"),
            createAnimalByName("Mr Pelmen"),
            createAnimalByName("Woff"),
            createAnimalByName("Melya"),
            createAnimalByName("Valeriy Nilolayevitch"),
            createAnimalByName("Joy")
        ));
        Assertions.assertEquals(3, animalsWithNameOfMoreThenOneWord.size());
        Assertions.assertTrue(animalsWithNameOfMoreThenOneWord.contains(createAnimalByName("Sweet Cat")));
        Assertions.assertTrue(animalsWithNameOfMoreThenOneWord.contains(createAnimalByName("Mr Pelmen")));
        Assertions.assertTrue(animalsWithNameOfMoreThenOneWord.contains(createAnimalByName("Valeriy Nilolayevitch")));

        Assertions.assertTrue(animalUtils.getAnimalsWithNameOfMoreThenOneWord(List.of()).isEmpty());
    }

    @Test
    void getAnimalsWithNameOfMoreThenOneWordExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> animalUtils.getAnimalsWithNameOfMoreThenOneWord(null)
        );
    }
}
