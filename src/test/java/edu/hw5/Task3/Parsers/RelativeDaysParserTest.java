package edu.hw5.Task3.Parsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class RelativeDaysParserTest {

    private final DateParser parser = new RelativeDaysParser();

    @Test
    void parse() {
        Assertions.assertEquals(LocalDate.now().minusDays(10), parser.parse("10 day ago"));
        Assertions.assertEquals(LocalDate.now().minusDays(1), parser.parse("1 day ago"));
        Assertions.assertEquals(LocalDate.now().minusDays(100), parser.parse("100 day ago"));
    }

    @Test
    void isMatch() {
        Assertions.assertTrue(parser.isMatch("10 day ago"));
        Assertions.assertTrue(parser.isMatch("1 day ago"));
        Assertions.assertFalse(parser.isMatch("=1 day ago"));
        Assertions.assertFalse(parser.isMatch("1 day agoasd"));
        Assertions.assertFalse(parser.isMatch("today"));
        Assertions.assertFalse(parser.isMatch("2020-10-10"));
        Assertions.assertFalse(parser.isMatch("hi"));
        Assertions.assertFalse(parser.isMatch("10/03/20"));
        Assertions.assertFalse(parser.isMatch("10/3/2020"));
        Assertions.assertFalse(parser.isMatch("20-10-10"));
    }

    @Test
    void Exceptions() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("a"));
    }
}
