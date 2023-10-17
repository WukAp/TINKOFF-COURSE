package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task3Test {
    private final Task3 testTask3 = new Task3();

    @Test
    void isNestable() {
        Assertions.assertTrue(testTask3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        Assertions.assertTrue(testTask3.isNestable(new int[] {3, 1}, new int[] {4, 0}));
        Assertions.assertFalse(testTask3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
        Assertions.assertFalse(testTask3.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
    }

    @Test
    void isNestableExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask3.isNestable(new int[] {}, new int[] {2, 3});
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask3.isNestable(null, new int[] {2, 3});
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask3.isNestable(new int[] {2, 3}, new int[] {});
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask3.isNestable(new int[] {2, 3}, null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask3.isNestable(null, null);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testTask3.isNestable(new int[] {}, new int[] {});
        });
    }
}
