package edu.hw5.Task3.Parsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class InternationalFormatParserTest {
    private final DateParser parser = new InternationalFormatParser();

    @Test
    void parse() {
        Assertions.assertEquals(LocalDate.of(2020, 12, 2), parser.parse("2020-12-2"));
        Assertions.assertEquals(LocalDate.of(1976, 3, 1), parser.parse("1976-3-1"));
        Assertions.assertEquals(LocalDate.of(2020, 1, 10), parser.parse("2020-1-10"));
        Assertions.assertEquals(LocalDate.of(2020, 10, 10), parser.parse("2020-10-10"));
    }

    @Test
    void isMatch() {
        Assertions.assertTrue(parser.isMatch("2020-12-2"));
        Assertions.assertTrue(parser.isMatch("1976-3-1"));
        Assertions.assertTrue(parser.isMatch("2020-1-10"));
        Assertions.assertTrue(parser.isMatch("2020-10-10"));
        Assertions.assertFalse(parser.isMatch("s2020-10-10"));
        Assertions.assertFalse(parser.isMatch("2020-10-10s"));
        Assertions.assertFalse(parser.isMatch("10/3/20"));
        Assertions.assertFalse(parser.isMatch("10/03/20"));
        Assertions.assertFalse(parser.isMatch("10/3/2020"));
        Assertions.assertFalse(parser.isMatch("20-10-10"));
    }

    @Test
    void Exceptions() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("a"));
    }
}
