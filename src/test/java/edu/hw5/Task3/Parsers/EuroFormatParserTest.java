package edu.hw5.Task3.Parsers;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EuroFormatParserTest {
    private final DateParser parser = new EuroFormatParser();

    @Test
    void parse() {
        assertEquals(LocalDate.of(2020, 3, 1), parser.parse("1/3/2020"));
        assertEquals(LocalDate.of(1976, 3, 1), parser.parse("1/3/1976"));
        assertEquals(LocalDate.of(2020, 3, 1), parser.parse("01/3/2020"));
        assertEquals(LocalDate.of(2020, 3, 1), parser.parse("1/03/2020"));
        assertEquals(LocalDate.of(2020, 3, 1), parser.parse("01/03/2020"));
    }

    @Test
    void isMatch() {
        assertTrue(parser.isMatch("1/3/1976"));
        assertTrue(parser.isMatch("1/03/1976"));
        assertTrue(parser.isMatch("01/3/1976"));
        assertFalse(parser.isMatch("s01/3/1976"));
        assertFalse(parser.isMatch("01/3/1976s"));
        assertFalse(parser.isMatch("1/3/20"));
        assertFalse(parser.isMatch("10/3/20"));
        assertFalse(parser.isMatch("10/03/20"));
        assertFalse(parser.isMatch("2020-10-10"));
        assertFalse(parser.isMatch("2020-10-10"));
    }

    @Test
    void Exceptions() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("a"));
    }
}
