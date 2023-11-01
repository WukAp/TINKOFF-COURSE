package edu.hw4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static edu.hw4.Animal.Sex.F;
import static edu.hw4.Animal.Type.BIRD;
import static edu.hw4.Animal.Type.CAT;

public class Task19Test {
    private final AnimalUtils animalUtils = new AnimalUtils();

    @Test
    void getIncorrectAnimals() {
        var incorrectAnimals = animalUtils.getIncorrectAnimals(List.of(
            new Animal(null, null, F, -20, -170, 50, false),
            new Animal("Sasha", BIRD, F, 20, 170, 50, false),
            new Animal("Pelmen", CAT, null, 20, 170, -50, false),
            new Animal("Fed", CAT, F, 20, -170, 50, false)
        ));
        Assertions.assertEquals(3, incorrectAnimals.size());
        Assertions.assertEquals(2, incorrectAnimals.get("Pelmen").size());
        Assertions.assertTrue(incorrectAnimals.get("Pelmen").stream()
            .anyMatch((o) -> o.getClass() == ValidationError.IllegalWeightArgumentException.class));
        Assertions.assertTrue(incorrectAnimals.get("Pelmen").stream()
            .anyMatch((o) -> o.getClass() == ValidationError.NullPointerSexException.class));

        Assertions.assertEquals(1, incorrectAnimals.get("Fed").size());
        Assertions.assertTrue(incorrectAnimals.get("Fed").stream()
            .anyMatch((o) -> o.getClass() == ValidationError.IllegalHeightArgumentException.class));

        Assertions.assertEquals(4, incorrectAnimals.get(null).size());
        Assertions.assertTrue(incorrectAnimals.get(null).stream()
            .anyMatch((o) -> o.getClass() == ValidationError.NullPointerNameException.class));
        Assertions.assertTrue(incorrectAnimals.get(null).stream()
            .anyMatch((o) -> o.getClass() == ValidationError.NullPointerTypeException.class));
        Assertions.assertTrue(incorrectAnimals.get(null).stream()
            .anyMatch((o) -> o.getClass() == ValidationError.IllegalAgeArgumentException.class));
        Assertions.assertTrue(incorrectAnimals.get(null).stream()
            .anyMatch((o) -> o.getClass() == ValidationError.IllegalHeightArgumentException.class));

        Assertions.assertNull(incorrectAnimals.get("Sasha"));

        Assertions.assertTrue(animalUtils.getIncorrectAnimals(List.of()).isEmpty());
    }

    @Test
    void getIncorrectAnimalsExceptions() {
        Assertions.assertThrows(
            NullPointerException.class,
            () -> animalUtils.getIncorrectAnimals(null)
        );
    }
}
