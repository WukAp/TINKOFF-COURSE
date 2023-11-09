package edu.hw5.Task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusBinaryStringsTest {
    BonusBinaryStrings binaryStrings = new BonusBinaryStrings();

    @Test
    void isOddLength() {
        Assertions.assertTrue(binaryStrings.isOddLength("1"));
        Assertions.assertTrue(binaryStrings.isOddLength("100"));
        Assertions.assertTrue(binaryStrings.isOddLength("10101"));
        Assertions.assertFalse(binaryStrings.isOddLength(""));
        Assertions.assertFalse(binaryStrings.isOddLength("10"));
        Assertions.assertFalse(binaryStrings.isOddLength("101010"));
        Assertions.assertFalse(binaryStrings.isOddLength("043"));
    }

    @Test
    void isOddAndStartsZeroOrEvenAndStartsOne() {
        Assertions.assertTrue(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("0"));
        Assertions.assertTrue(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("011"));
        Assertions.assertTrue(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("10"));
        Assertions.assertTrue(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("1001"));
        Assertions.assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("01"));
        Assertions.assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("100"));
        Assertions.assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne(""));
        Assertions.assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("043"));
    }

    @Test
    void isZerosAmountIsDivisibleByThree() {
        Assertions.assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("101010"));
        Assertions.assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("000"));
        Assertions.assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("0001000"));
        Assertions.assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("000000"));
        Assertions.assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree("111"));
        Assertions.assertTrue(binaryStrings.isZerosAmountIsDivisibleByThree(""));
        Assertions.assertFalse(binaryStrings.isZerosAmountIsDivisibleByThree("1011"));
        Assertions.assertFalse(binaryStrings.isZerosAmountIsDivisibleByThree("0000"));
        Assertions.assertFalse(binaryStrings.isZerosAmountIsDivisibleByThree("10100100"));
        Assertions.assertFalse(binaryStrings.isOddAndStartsZeroOrEvenAndStartsOne("043"));
    }

    @Test
    void isNot11or111() {
        Assertions.assertTrue(binaryStrings.isNot11or111("101010"));
        Assertions.assertTrue(binaryStrings.isNot11or111("000"));
        Assertions.assertTrue(binaryStrings.isNot11or111("0001000"));
        Assertions.assertTrue(binaryStrings.isNot11or111("1111"));
        Assertions.assertTrue(binaryStrings.isNot11or111(""));
        Assertions.assertFalse(binaryStrings.isNot11or111("111"));
        Assertions.assertFalse(binaryStrings.isNot11or111("11"));
    }

    @Test
    void isEveryOddSymbolIsOne() {
        Assertions.assertTrue(binaryStrings.isEveryOddSymbolIsOne("1111"));
        Assertions.assertTrue(binaryStrings.isEveryOddSymbolIsOne("101"));
        Assertions.assertTrue(binaryStrings.isEveryOddSymbolIsOne("101010"));
        Assertions.assertTrue(binaryStrings.isEveryOddSymbolIsOne("1"));
        Assertions.assertTrue(binaryStrings.isEveryOddSymbolIsOne(""));
        Assertions.assertTrue(binaryStrings.isEveryOddSymbolIsOne("10111"));
        Assertions.assertFalse(binaryStrings.isEveryOddSymbolIsOne("000"));
        Assertions.assertFalse(binaryStrings.isEveryOddSymbolIsOne("0100"));
        Assertions.assertFalse(binaryStrings.isEveryOddSymbolIsOne("01010"));
        Assertions.assertFalse(binaryStrings.isEveryOddSymbolIsOne("043"));
    }

    @Test
    void isTwoOrMoreZerosAndOneOrLessOne() {
        Assertions.assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("001"));
        Assertions.assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("001000"));
        Assertions.assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("00001"));
        Assertions.assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("010000"));
        Assertions.assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("10000"));
        Assertions.assertTrue(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("0000"));
        Assertions.assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne(""));
        Assertions.assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("000011"));
        Assertions.assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("1"));
        Assertions.assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("10"));
        Assertions.assertFalse(binaryStrings.isTwoOrMoreZerosAndOneOrLessOne("043"));
    }

    @Test
    void isNotContains11() {
        Assertions.assertTrue(binaryStrings.isNotContains11("001"));
        Assertions.assertTrue(binaryStrings.isNotContains11("01"));
        Assertions.assertTrue(binaryStrings.isNotContains11(""));
        Assertions.assertTrue(binaryStrings.isNotContains11("1010101010101000"));
        Assertions.assertFalse(binaryStrings.isNotContains11("11"));
        Assertions.assertFalse(binaryStrings.isNotContains11("111"));
        Assertions.assertFalse(binaryStrings.isNotContains11("011100011"));
    }
}
