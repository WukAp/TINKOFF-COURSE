package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task5Test {

    private final Task5 testTask5 = new Task5();

    @Test
    void isPalindromeDescendantPositive() {
        Assertions.assertTrue(testTask5.isPalindromeDescendant(11211230)); // 11211230 -> 2333 -> 56 -> 11
        Assertions.assertTrue(testTask5.isPalindromeDescendant(13001120)); // 13001120 -> 4022 ➞ 44
        Assertions.assertTrue(testTask5.isPalindromeDescendant(23336014)); // 23336014 -> 5665
        Assertions.assertTrue(testTask5.isPalindromeDescendant(11));
        Assertions.assertTrue(testTask5.isPalindromeDescendant(1));

        Assertions.assertFalse(testTask5.isPalindromeDescendant(12345)); //12345 -> х
        Assertions.assertFalse(testTask5.isPalindromeDescendant(123456)); //123456 -> 3711 -> 103 -> х
        Assertions.assertFalse(testTask5.isPalindromeDescendant(123456)); //123456 -> 2711 -> 93 -> 10
    }

    @Test
    void isPalindromeDescendantNegative() {
        Assertions.assertTrue(testTask5.isPalindromeDescendant(-11211230)); // 11211230 -> 2333 -> 56 -> 11
        Assertions.assertTrue(testTask5.isPalindromeDescendant(-13001120)); // 13001120 -> 4022 ➞ 44
        Assertions.assertTrue(testTask5.isPalindromeDescendant(-23336014)); // 23336014 -> 5665
        Assertions.assertTrue(testTask5.isPalindromeDescendant(-11));
        Assertions.assertTrue(testTask5.isPalindromeDescendant(-1));

        Assertions.assertFalse(testTask5.isPalindromeDescendant(-12345)); //12345 -> х
        Assertions.assertFalse(testTask5.isPalindromeDescendant(-123456)); //123456 -> 3711 -> 103 -> х
        Assertions.assertFalse(testTask5.isPalindromeDescendant(-123456)); //123456 -> 2711 -> 93 -> 10
    }
}
