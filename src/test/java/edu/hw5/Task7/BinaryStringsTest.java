package edu.hw5.Task7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryStringsTest {
    private final BinaryStrings binaryStrings = new BinaryStrings();

    @Test
    void isLongerThanTwoCharactersAndTheThirdIsZero() {
        assertTrue(binaryStrings.isTheThirdCharacterIsZero("000"));
        assertTrue(binaryStrings.isTheThirdCharacterIsZero("110"));
        assertTrue(binaryStrings.isTheThirdCharacterIsZero("0100010"));
        assertFalse(binaryStrings.isTheThirdCharacterIsZero("0"));
        assertFalse(binaryStrings.isTheThirdCharacterIsZero("001"));
        assertFalse(binaryStrings.isTheThirdCharacterIsZero("01111110"));
        assertFalse(binaryStrings.isTheThirdCharacterIsZero("11111"));
    }

    @Test
    void isFirstEqualsLast() {
        assertTrue(binaryStrings.isFirstEqualsLast("000"));
        assertTrue(binaryStrings.isFirstEqualsLast("1000001"));
        assertTrue(binaryStrings.isFirstEqualsLast("1010101"));
        assertTrue(binaryStrings.isFirstEqualsLast("1"));
        assertTrue(binaryStrings.isFirstEqualsLast("0"));
        assertFalse(binaryStrings.isFirstEqualsLast(""));
        assertFalse(binaryStrings.isFirstEqualsLast("01"));
        assertFalse(binaryStrings.isFirstEqualsLast("1101010"));
    }

    @Test
    void isLengthBetweenOneAndThree() {
        assertTrue(binaryStrings.isLengthBetweenOneAndThree("000"));
        assertTrue(binaryStrings.isLengthBetweenOneAndThree("01"));
        assertTrue(binaryStrings.isLengthBetweenOneAndThree("1"));
        assertFalse(binaryStrings.isLengthBetweenOneAndThree(""));
        assertFalse(binaryStrings.isLengthBetweenOneAndThree("1001"));
        assertFalse(binaryStrings.isLengthBetweenOneAndThree("10010"));
    }

    @Test
    void illegalArgumentExceptions() {
        assertThrows(IllegalArgumentException.class, () -> binaryStrings.isTheThirdCharacterIsZero("104"));
        assertThrows(IllegalArgumentException.class, () -> binaryStrings.isFirstEqualsLast("104"));
        assertThrows(IllegalArgumentException.class, () -> binaryStrings.isLengthBetweenOneAndThree("104"));
    }
}
