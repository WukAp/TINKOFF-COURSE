package edu.hw5.Task8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BonusBinaryStringsTest {
    BonusBinaryStrings binaryStrings = new BonusBinaryStrings();

    @Test
    void isOddLength() {
        assertTrue(binaryStrings.isOddLength("1"));
        assertTrue(binaryStrings.isOddLength("100"));
        assertTrue(binaryStrings.isOddLength("10101"));
        assertFalse(binaryStrings.isOddLength(""));
        assertFalse(binaryStrings.isOddLength("10"));
        assertFalse(binaryStrings.isOddLength("101010"));
        assertFalse(binaryStrings.isOddLength("043"));
    }

    @Test
    void isOddAndStartsZeroOrEvenAndStartsOne() {
        assertTrue(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("0"));
        assertTrue(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("011"));
        assertTrue(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("10"));
        assertTrue(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("1001"));
        assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("01"));
        assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("100"));
        assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne(""));
        assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("043"));
    }

    @Test
    void isZerosAmountIsDivisibleByThree() {
        assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("101010"));
        assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("000"));
        assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("0001000"));
        assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("000000"));
        assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("111"));
        assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree(""));
        assertFalse(binaryStrings.isZerosAmountIsDivisibleByThree("1011"));
        assertFalse(binaryStrings.isZerosAmountIsDivisibleByThree("0000"));
        assertFalse(binaryStrings.isZerosAmountIsDivisibleByThree("10100100"));
        assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("043"));
    }

    @Test
    void isNot11or111() {
        assertTrue(binaryStrings.isNot11or111("101010"));
        assertTrue(binaryStrings.isNot11or111("000"));
        assertTrue(binaryStrings.isNot11or111("0001000"));
        assertTrue(binaryStrings.isNot11or111("1111"));
        assertTrue(binaryStrings.isNot11or111(""));
        assertFalse(binaryStrings.isNot11or111("111"));
        assertFalse(binaryStrings.isNot11or111("11"));
    }

    @Test
    void isEveryOddSymbolIsOne() {
        assertTrue(binaryStrings.isEveryOddSymbolIsOne("1111"));
        assertTrue(binaryStrings.isEveryOddSymbolIsOne("101"));
        assertTrue(binaryStrings.isEveryOddSymbolIsOne("101010"));
        assertTrue(binaryStrings.isEveryOddSymbolIsOne("1"));
        assertTrue(binaryStrings.isEveryOddSymbolIsOne(""));
        assertTrue(binaryStrings.isEveryOddSymbolIsOne("10111"));
        assertFalse(binaryStrings.isEveryOddSymbolIsOne("000"));
        assertFalse(binaryStrings.isEveryOddSymbolIsOne("0100"));
        assertFalse(binaryStrings.isEveryOddSymbolIsOne("01010"));
        assertFalse(binaryStrings.isEveryOddSymbolIsOne("043"));
    }

    @Test
    void isTwoOrMoreZerosAndOneOrLessOne() {
        assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("001"));
        assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("001000"));
        assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("00001"));
        assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("010000"));
        assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("10000"));
        assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("0000"));
        assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne(""));
        assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("000011"));
        assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("1"));
        assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("10"));
        assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("043"));
    }

    @Test
    void isNotContains11() {
        assertTrue(binaryStrings.isNotContains11("001"));
        assertTrue(binaryStrings.isNotContains11("01"));
        assertTrue(binaryStrings.isNotContains11(""));
        assertTrue(binaryStrings.isNotContains11("1010101010101000"));
        assertFalse(binaryStrings.isNotContains11("11"));
        assertFalse(binaryStrings.isNotContains11("111"));
        assertFalse(binaryStrings.isNotContains11("011100011"));
    }
}
