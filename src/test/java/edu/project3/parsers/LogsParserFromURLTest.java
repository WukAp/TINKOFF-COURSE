package edu.project3.parsers;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LogsParserFromURLTest {

    @Test
    void constructors() {
        assertDoesNotThrow(() -> new LogsParserFromURL(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs")
        );
        assertDoesNotThrow(() -> new LogsParserFromURL(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs",
            new LogRecordFilter.FilterWithFromDate(LocalDate.of(2015, 7, 12))
        ));
    }

    @Test
    void getLogReports() throws MalformedURLException {
        var report = new LogsParserFromURL(
            "https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs")
            .getLogReports();

        assertEquals(51462, report.size());
    }
}
