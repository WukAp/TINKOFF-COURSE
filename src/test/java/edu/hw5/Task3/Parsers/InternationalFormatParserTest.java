package edu.hw5.Task3.Parsers;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InternationalFormatParserTest {
    private final DateParser parser = new InternationalFormatParser();

    @Test
    void parse() {
        assertEquals(LocalDate.of(2020, 12, 2), parser.parse("2020-12-2"));
        assertEquals(LocalDate.of(1976, 3, 1), parser.parse("1976-3-1"));
        assertEquals(LocalDate.of(2020, 1, 10), parser.parse("2020-1-10"));
        assertEquals(LocalDate.of(2020, 10, 10), parser.parse("2020-10-10"));
    }

    @Test
    void isMatch() {
        assertTrue(parser.isMatch("2020-12-2"));
        assertTrue(parser.isMatch("1976-3-1"));
        assertTrue(parser.isMatch("2020-1-10"));
        assertTrue(parser.isMatch("2020-10-10"));
        assertFalse(parser.isMatch("s2020-10-10"));
        assertFalse(parser.isMatch("2020-10-10s"));
        assertFalse(parser.isMatch("10/3/20"));
        assertFalse(parser.isMatch("10/03/20"));
        assertFalse(parser.isMatch("10/3/2020"));
        assertFalse(parser.isMatch("20-10-10"));
    }

    @Test
    void Exceptions() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("a"));
    }
}
