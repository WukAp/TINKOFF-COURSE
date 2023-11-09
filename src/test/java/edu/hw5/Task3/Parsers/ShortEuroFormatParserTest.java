package edu.hw5.Task3.Parsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ShortEuroFormatParserTest {
    private final DateParser parser = new ShortEuroFormatParser();

    @Test
    void parse() {
        Assertions.assertEquals(LocalDate.of(2020, 3, 1), parser.parse("1/3/20"));
        Assertions.assertEquals(LocalDate.of(2020, 3, 1), parser.parse("01/3/20"));
        Assertions.assertEquals(LocalDate.of(2020, 3, 1), parser.parse("1/03/20"));
    }

    @Test
    void isMatch() {
        Assertions.assertTrue(parser.isMatch("1/3/20"));
        Assertions.assertTrue(parser.isMatch("10/3/20"));
        Assertions.assertTrue(parser.isMatch("10/03/20"));
        Assertions.assertFalse(parser.isMatch("a10/03/20"));
        Assertions.assertFalse(parser.isMatch("10/03/20s"));
        Assertions.assertFalse(parser.isMatch("1/3/1976"));
        Assertions.assertFalse(parser.isMatch("2020-10-10"));
        Assertions.assertFalse(parser.isMatch("2020-10-10"));
    }

    @Test
    void Exceptions() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("a"));
    }
}
