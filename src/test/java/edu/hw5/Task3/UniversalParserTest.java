package edu.hw5.Task3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UniversalParserTest {

    private final UniversalParser parser = new UniversalParser();

    @Test
    void parseDate() {
        assertEquals(
            LocalDate.of(2020, 3, 1),
            parser.parseDate("1/3/20").orElseThrow()
        );
        assertEquals(
            LocalDate.of(2020, 12, 2),
            parser.parseDate("2020-12-2").orElseThrow()
        );
        assertEquals(
            LocalDate.of(1976, 3, 1),
            parser.parseDate("1/3/1976").orElseThrow()
        );
        assertEquals(
            LocalDate.of(2020, 3, 1),
            parser.parseDate("1/3/20").orElseThrow()
        );
        assertEquals(
            LocalDate.of(2020, 3, 1),
            parser.parseDate("1/3/20").orElseThrow()
        );
        assertEquals(
            LocalDate.now().plusDays(1),
            parser.parseDate("tomorrow").orElseThrow()
        );
        assertEquals(
            LocalDate.now(),
            parser.parseDate("today").orElseThrow()
        );
        assertEquals(
            LocalDate.now().minusDays(1),
            parser.parseDate("yesterday").orElseThrow()
        );
        assertEquals(
            LocalDate.now().minusDays(1),
            parser.parseDate("1 day ago").orElseThrow()
        );
        assertEquals(
            LocalDate.now().minusDays(2234),
            parser.parseDate("2234 days ago").orElseThrow()
        );
        assertFalse(parser.parseDate("o").isPresent());
    }
}
