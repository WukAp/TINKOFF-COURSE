package edu.hw5.Task3;

import edu.hw5.Task3.Parsers.DateParser;
import edu.hw5.Task3.Parsers.EuroFormatParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class UniversalParserTest {

    private final UniversalParser parser = new UniversalParser();

    @Test
    void parseDate() {
        Assertions.assertEquals(
            LocalDate.of(2020, 3, 1),
            parser.parseDate("1/3/20").orElseThrow()
        );
        Assertions.assertEquals(
            LocalDate.of(2020, 12, 2),
            parser.parseDate("2020-12-2").orElseThrow()
        );
        Assertions.assertEquals(
            LocalDate.of(1976, 3, 1),
            parser.parseDate("1/3/1976").orElseThrow()
        );
        Assertions.assertEquals(
            LocalDate.of(2020, 3, 1),
            parser.parseDate("1/3/20").orElseThrow()
        );
        Assertions.assertEquals(
            LocalDate.of(2020, 3, 1),
            parser.parseDate("1/3/20").orElseThrow()
        );
        Assertions.assertEquals(
            LocalDate.now().plusDays(1),
            parser.parseDate("tomorrow").orElseThrow()
        );
        Assertions.assertEquals(
            LocalDate.now(),
            parser.parseDate("today").orElseThrow()
        );
        Assertions.assertEquals(
            LocalDate.now().minusDays(1),
            parser.parseDate("yesterday").orElseThrow()
        );
        Assertions.assertEquals(
            LocalDate.now().minusDays(1),
            parser.parseDate("1 day ago").orElseThrow()
        );
        Assertions.assertEquals(
            LocalDate.now().minusDays(2234),
            parser.parseDate("2234 days ago").orElseThrow()
        );
        Assertions.assertFalse(parser.parseDate("o").isPresent());
    }
}
