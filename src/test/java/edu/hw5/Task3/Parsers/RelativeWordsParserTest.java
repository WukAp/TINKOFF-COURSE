package edu.hw5.Task3.Parsers;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RelativeWordsParserTest {
    private final DateParser parser = new RelativeWordsParser();

    @Test
    void parse() {
        assertEquals(LocalDate.now(), parser.parse("today"));
        assertEquals(LocalDate.now().minusDays(1), parser.parse("yesterday"));
        assertEquals(LocalDate.now().plusDays(1), parser.parse("tomorrow"));
    }

    @Test
    void isMatch() {
        assertTrue(parser.isMatch("today"));
        assertTrue(parser.isMatch("yesterday"));
        assertTrue(parser.isMatch("tomorrow"));
        assertFalse(parser.isMatch("qtoday"));
        assertFalse(parser.isMatch("todayq"));
        assertFalse(parser.isMatch("2020-10-10"));
        assertFalse(parser.isMatch("hi"));
        assertFalse(parser.isMatch("10/03/20"));
        assertFalse(parser.isMatch("10/3/2020"));
        assertFalse(parser.isMatch("20-10-10"));
    }

    @Test
    void Exceptions() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("a"));
    }
}
