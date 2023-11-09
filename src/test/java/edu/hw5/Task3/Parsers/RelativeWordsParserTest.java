package edu.hw5.Task3.Parsers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class RelativeWordsParserTest {
    private final DateParser parser = new RelativeWordsParser();

    @Test
    void parse() {
        Assertions.assertEquals(LocalDate.now(), parser.parse("today"));
        Assertions.assertEquals(LocalDate.now().minusDays(1), parser.parse("yesterday"));
        Assertions.assertEquals(LocalDate.now().plusDays(1), parser.parse("tomorrow"));
    }

    @Test
    void isMatch() {
        Assertions.assertTrue(parser.isMatch("today"));
        Assertions.assertTrue(parser.isMatch("yesterday"));
        Assertions.assertTrue(parser.isMatch("tomorrow"));
        Assertions.assertFalse(parser.isMatch("qtoday"));
        Assertions.assertFalse(parser.isMatch("todayq"));
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
