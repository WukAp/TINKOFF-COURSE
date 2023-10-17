package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task6Test {

    private final Task6 testTask6 = new Task6();

    @Test
    void countK() {
        Assertions.assertEquals(3, testTask6.countK(3524));
        Assertions.assertEquals(5, testTask6.countK(6621));
        Assertions.assertEquals(4, testTask6.countK(6554));
        Assertions.assertEquals(3, testTask6.countK(1234));
        Assertions.assertEquals(0, testTask6.countK(6174));
    }

    @Test
    void countKExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask6.countK(1);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask6.countK(90);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask6.countK(1000);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask6.countK(-1966);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask6.countK(11966);
        });
    }
}
