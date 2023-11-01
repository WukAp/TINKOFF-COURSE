package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;

public class Task20Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getPrettyPrintIncorrectAnimals() {
        var prettyPrintIncorrectAnimals = animalUtils.getPrettyPrintIncorrectAnimals(List.of(
            new Animal(null, null, F, -20, -170, 50, false),
            new Animal("Sasha", BIRD, F, 20, 170, 50, false),
            new Animal("Pelmen", CAT, null, 20, 170, -50, false),
            new Animal("Fed", CAT, F, 20, -170, 50, false)
        ));
        Assertions.assertEquals(3, prettyPrintIncorrectAnimals.size());

        Assertions.assertEquals("[sex, weight]".length(), prettyPrintIncorrectAnimals.get("Pelmen").length());
        Assertions.assertTrue(prettyPrintIncorrectAnimals.get("Pelmen").contains("sex"));
        Assertions.assertTrue(prettyPrintIncorrectAnimals.get("Pelmen").contains("weight"));

        Assertions.assertEquals("[height]".length(), prettyPrintIncorrectAnimals.get("Fed").length());
        Assertions.assertTrue(prettyPrintIncorrectAnimals.get("Fed").contains("height"));

        Assertions.assertEquals("[name, type, age, height]".length(), prettyPrintIncorrectAnimals.get(null).length());
        Assertions.assertTrue(prettyPrintIncorrectAnimals.get(null).contains("name"));
        Assertions.assertTrue(prettyPrintIncorrectAnimals.get(null).contains("type"));
        Assertions.assertTrue(prettyPrintIncorrectAnimals.get(null).contains("age"));
        Assertions.assertTrue(prettyPrintIncorrectAnimals.get(null).contains("height"));

        Assertions.assertNull(prettyPrintIncorrectAnimals.get("Sasha"));

        Assertions.assertTrue(animalUtils.getPrettyPrintIncorrectAnimals(List.of()).isEmpty());
    }

    @Test
    void getPrettyPrintIncorrectAnimalsExceptions() {
        Assertions.assertThrows(
            NullPointerException.class,
            () -> animalUtils.getPrettyPrintIncorrectAnimals(null)
        );
    }
}
