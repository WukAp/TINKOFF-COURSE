package edu.project3.models;

import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static org.junit.jupiter.api.Assertions.*;

class LogRecordTest {

    @Test
    void parseLogRecord() throws IOException {
        LogRecord logReport = LogRecord.parseLogRecord(
            "93.180.71.3 - - [17/May/2015:08:05:57 +0000] " +
                "\"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"");
        assertEquals("93.180.71.3", logReport.remoteAddress());
        assertEquals("-", logReport.remoteUser());
        assertEquals(
            ZonedDateTime.of(LocalDateTime.of(2015, 5, 17, 8, 5, 57), ZoneId.of("Z")).toOffsetDateTime(),
            logReport.timeLocal()
        );
        assertEquals(RequestMethod.GET, logReport.requestMethod());
        assertEquals("/downloads/product_1", logReport.requestUrl());
        assertEquals("HTTP/1.1", logReport.requestProtocol());
        assertEquals(HttpStatus.getCode(304), logReport.codeStatus());
        assertEquals(0, logReport.bodyBytesSent());
        assertEquals("-", logReport.httpReferer());
        assertEquals("Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)", logReport.httpUserAgent());
    }

    @Test
    void parseLogRecordException() {
        assertThrows(IOException.class, () -> LogRecord.parseLogRecord("Illegal line"));
    }
}
