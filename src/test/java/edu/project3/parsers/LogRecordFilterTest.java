package edu.project3.parsers;

import edu.project3.models.LogRecord;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LogRecordFilterTest {
    LogRecord logRecord2015 = LogRecord.parseLogRecord(
        "93.180.71.3 - - [17/May/2015:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"");
    LogRecord logRecord2020 = LogRecord.parseLogRecord(
        "93.180.71.3 - - [17/May/2020:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"");
    LocalDate date2018 = LocalDate.of(2018, 7, 12);
    LocalDate date2024 = LocalDate.of(2024, 7, 12);

    LogRecordFilterTest() throws IOException {
    }

    @Test
    void isRequiredEmptyConditionalFilter() {
        LogRecordFilter filter = new LogRecordFilter.EmptyConditionalFilter();
        assertTrue(filter.isRequired(logRecord2015));
        assertTrue(filter.isRequired(logRecord2020));
    }

    @Test
    void isRequiredFilterWithFromDate() {
        LogRecordFilter filter = new LogRecordFilter.FilterWithFromDate(date2018);
        assertFalse(filter.isRequired(logRecord2015));
        assertTrue(filter.isRequired(logRecord2020));
        filter = new LogRecordFilter.FilterWithFromDate(date2024);
        assertFalse(filter.isRequired(logRecord2015));
        assertFalse(filter.isRequired(logRecord2020));
    }

    @Test
    void isRequiredFilterWithToDate() {
        LogRecordFilter filter = new LogRecordFilter.FilterWithToDate(date2018);
        assertTrue(filter.isRequired(logRecord2015));
        assertFalse(filter.isRequired(logRecord2020));
        filter = new LogRecordFilter.FilterWithToDate(date2024);
        assertTrue(filter.isRequired(logRecord2015));
        assertTrue(filter.isRequired(logRecord2020));
    }

    @Test
    void isRequiredFilterFilterWithFromToDate() {
        LogRecordFilter filter = new LogRecordFilter.FilterWithFromToDate(date2018, date2018);
        assertFalse(filter.isRequired(logRecord2015));
        assertFalse(filter.isRequired(logRecord2020));
        filter = new LogRecordFilter.FilterWithFromToDate(date2018, date2024);
        assertFalse(filter.isRequired(logRecord2015));
        assertTrue(filter.isRequired(logRecord2020));
    }
}
