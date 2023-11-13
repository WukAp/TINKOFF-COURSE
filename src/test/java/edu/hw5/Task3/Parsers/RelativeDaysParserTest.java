package edu.hw5.Task3.Parsers;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RelativeDaysParserTest {

    private final DateParser parser = new RelativeDaysParser();

    @Test
    void parse() {
        assertEquals(LocalDate.now().minusDays(10), parser.parse("10 day ago"));
        assertEquals(LocalDate.now().minusDays(1), parser.parse("1 day ago"));
        assertEquals(LocalDate.now().minusDays(100), parser.parse("100 day ago"));
    }

    @Test
    void isMatch() {
        assertTrue(parser.isMatch("10 day ago"));
        assertTrue(parser.isMatch("1 day ago"));
        assertFalse(parser.isMatch("=1 day ago"));
        assertFalse(parser.isMatch("1 day agoasd"));
        assertFalse(parser.isMatch("today"));
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
