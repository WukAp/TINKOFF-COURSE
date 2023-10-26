package edu.hw3.Task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    @Test
    void convertToRoman() {
        RomanNumeral romanNumeral = new RomanNumeral();
        Assertions.assertEquals("II", romanNumeral.convertToRoman(2));
        Assertions.assertEquals("XII", romanNumeral.convertToRoman(12));
        Assertions.assertEquals("XVI", romanNumeral.convertToRoman(16));
    }

    @Test
    void convertToRomanExceptions() {
        RomanNumeral romanNumeral = new RomanNumeral();
        Assertions.assertThrows(IllegalArgumentException.class, () -> romanNumeral.convertToRoman(-2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> romanNumeral.convertToRoman(0));
    }
}
