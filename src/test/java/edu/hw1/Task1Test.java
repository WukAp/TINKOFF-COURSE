package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {
    private final Task1 testTask1 = new Task1();

    @Test void minutesToSecondsWithCorrectParams() {
        Assertions.assertEquals(0, testTask1.minutesToSeconds("0:0"));

        Assertions.assertEquals(50, testTask1.minutesToSeconds("0:50"));

        Assertions.assertEquals(60, testTask1.minutesToSeconds("1:00"));

        Assertions.assertEquals(70, testTask1.minutesToSeconds("1:10"));

        Assertions.assertEquals(60010, testTask1.minutesToSeconds("1000:10"));
    }

    @Test void minutesToSecondsWithIncorrectParams() {

        Assertions.assertEquals(-1, testTask1.minutesToSeconds(""));

        Assertions.assertEquals(-1, testTask1.minutesToSeconds("a"));

        Assertions.assertEquals(-1, testTask1.minutesToSeconds("1:60"));

        Assertions.assertEquals(-1, testTask1.minutesToSeconds(":10"));

        Assertions.assertEquals(-1, testTask1.minutesToSeconds("0"));
    }

    @Test void minutesToSecondsExceptions() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask1.minutesToSeconds(null);
        });
    }
}
