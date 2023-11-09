package edu.hw5.Task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryStringsTest {
    private final BinaryStrings binaryStrings = new BinaryStrings();

    @Test
    void isLongerThanTwoCharactersAndTheThirdIsZero() {
        Assertions.assertTrue(binaryStrings.isTheThirdCharacterIsZero("000"));
        Assertions.assertTrue(binaryStrings.isTheThirdCharacterIsZero("110"));
        Assertions.assertTrue(binaryStrings.isTheThirdCharacterIsZero("0100010"));
        Assertions.assertFalse(binaryStrings.isTheThirdCharacterIsZero("0"));
        Assertions.assertFalse(binaryStrings.isTheThirdCharacterIsZero("001"));
        Assertions.assertFalse(binaryStrings.isTheThirdCharacterIsZero("01111110"));
        Assertions.assertFalse(binaryStrings.isTheThirdCharacterIsZero("11111"));
    }

    @Test
    void isFirstEqualsLast() {
        Assertions.assertTrue(binaryStrings.isFirstEqualsLast("000"));
        Assertions.assertTrue(binaryStrings.isFirstEqualsLast("1000001"));
        Assertions.assertTrue(binaryStrings.isFirstEqualsLast("1010101"));
        Assertions.assertTrue(binaryStrings.isFirstEqualsLast("1"));
        Assertions.assertTrue(binaryStrings.isFirstEqualsLast("0"));
        Assertions.assertFalse(binaryStrings.isFirstEqualsLast(""));
        Assertions.assertFalse(binaryStrings.isFirstEqualsLast("01"));
        Assertions.assertFalse(binaryStrings.isFirstEqualsLast("1101010"));
    }

    @Test
    void isLengthBetweenOneAndThree() {
        Assertions.assertTrue(binaryStrings.isLengthBetweenOneAndThree("000"));
        Assertions.assertTrue(binaryStrings.isLengthBetweenOneAndThree("01"));
        Assertions.assertTrue(binaryStrings.isLengthBetweenOneAndThree("1"));
        Assertions.assertFalse(binaryStrings.isLengthBetweenOneAndThree(""));
        Assertions.assertFalse(binaryStrings.isLengthBetweenOneAndThree("1001"));
        Assertions.assertFalse(binaryStrings.isLengthBetweenOneAndThree("10010"));
    }

    @Test
    void illegalArgumentExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> binaryStrings.isTheThirdCharacterIsZero("104"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> binaryStrings.isFirstEqualsLast("104"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> binaryStrings.isLengthBetweenOneAndThree("104"));
    }
}
