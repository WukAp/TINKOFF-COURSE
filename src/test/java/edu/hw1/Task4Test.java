package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task4Test {
    private final Task4 testTask4 = new Task4();

    @Test void fixString() {
        Assertions.assertEquals("", testTask4.fixString(""));
        Assertions.assertEquals("abcde", testTask4.fixString("badce"));
        Assertions.assertEquals("214365", testTask4.fixString("123456"));
        Assertions.assertEquals("This is a mixed up string.", testTask4.fixString("hTsii  s aimex dpus rtni.g"));
        Assertions.assertEquals("This is a mixed up string", testTask4.fixString("hTsii  s aimex dpus rtnig"));
    }

    @Test
    void fixStringExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask4.fixString(null);
        });
    }
}
