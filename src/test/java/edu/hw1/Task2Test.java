package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {
    private final Task2 testTask2 = new Task2();

    @Test
    void countDigitsPositive() {
        Assertions.assertEquals(1, testTask2.countDigits(0));
        Assertions.assertEquals(1, testTask2.countDigits(1));
        Assertions.assertEquals(3, testTask2.countDigits(100));
        Assertions.assertEquals(2, testTask2.countDigits(50));
        Assertions.assertEquals(9, testTask2.countDigits(123456789));
    }

    @Test
    void countDigitsNegative() {
        Assertions.assertEquals(1, testTask2.countDigits(-1));
        Assertions.assertEquals(3, testTask2.countDigits(-100));
        Assertions.assertEquals(2, testTask2.countDigits(-50));
        Assertions.assertEquals(9, testTask2.countDigits(-123456789));
    }
}
