package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task7Test {
    private final Task7 testTask7 = new Task7();

    @Test
    void rotateLeft() {
        Assertions.assertEquals(1, testTask7.rotateLeft(16, 1));
        Assertions.assertEquals(6, testTask7.rotateLeft(17, 2));
        Assertions.assertEquals(4, testTask7.rotateLeft(8, -1));
    }

    @Test
    void rotateRight() {
        Assertions.assertEquals(4, testTask7.rotateRight(8, 1));

        Assertions.assertEquals(1, testTask7.rotateRight(16, -1));
        Assertions.assertEquals(6, testTask7.rotateRight(17, -2));
    }
}
