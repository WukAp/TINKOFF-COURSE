package edu.hw5.Task3.Parsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.parser.Parser;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EuroFormatParserTest {
    private final DateParser parser = new EuroFormatParser();

    @Test
    void parse() {
        Assertions.assertEquals(LocalDate.of(2020, 3, 1), parser.parse("1/3/2020"));
        Assertions.assertEquals(LocalDate.of(1976, 3, 1), parser.parse("1/3/1976"));
        Assertions.assertEquals(LocalDate.of(2020, 3, 1), parser.parse("01/3/2020"));
        Assertions.assertEquals(LocalDate.of(2020, 3, 1), parser.parse("1/03/2020"));
        Assertions.assertEquals(LocalDate.of(2020, 3, 1), parser.parse("01/03/2020"));
    }

    @Test
    void isMatch() {
        Assertions.assertTrue(parser.isMatch("1/3/1976"));
        Assertions.assertTrue(parser.isMatch("1/03/1976"));
        Assertions.assertTrue(parser.isMatch("01/3/1976"));
        Assertions.assertFalse(parser.isMatch("s01/3/1976"));
        Assertions.assertFalse(parser.isMatch("01/3/1976s"));
        Assertions.assertFalse(parser.isMatch("1/3/20"));
        Assertions.assertFalse(parser.isMatch("10/3/20"));
        Assertions.assertFalse(parser.isMatch("10/03/20"));
        Assertions.assertFalse(parser.isMatch("2020-10-10"));
        Assertions.assertFalse(parser.isMatch("2020-10-10"));
    }

    @Test
    void Exceptions() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("a"));
    }
}
