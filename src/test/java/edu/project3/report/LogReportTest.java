package edu.project3.report;

import edu.project3.models.LogRecord;
import edu.project3.models.RequestMethod;
import edu.project3.parsers.LogsParserFromFile;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LogReportTest {
    private final List<LogRecord> logs =
        new LogsParserFromFile("src/main/resources/project3/smallLogs.txt").getLogReports();
    private final LogReport report = new LogReport(logs);

    LogReportTest() throws IOException {
    }

    @Test
    void getLogsAmount() {
        assertEquals(10, report.getLogsAmount());
    }

    @Test
    void getPopularRequestsURL() {
        var popularRequests = report.getPopularRequestsURL(2);
        assertEquals(2, popularRequests.size());
        assertEquals(6, popularRequests.get("/downloads/product_1"));
        assertEquals(3, popularRequests.get("/downloads/product_2"));
    }

    @Test
    void getPopularCodes() {
        var popularCodes = report.getPopularCodes(3);
        assertEquals(3, popularCodes.size());
        assertEquals(5, popularCodes.get(HttpStatus.getCode(304)));
        assertEquals(2, popularCodes.get(HttpStatus.getCode(200)));
        assertEquals(2, popularCodes.get(HttpStatus.getCode(404)));
    }

    @Test
    void getRequestMethodCounted() {
        var requestMethodCounted = report.getRequestMethodCounted();
        assertEquals(3, requestMethodCounted.size());
        assertEquals(7, requestMethodCounted.get(RequestMethod.GET));
        assertEquals(2, requestMethodCounted.get(RequestMethod.POST));
        assertEquals(1, requestMethodCounted.get(RequestMethod.DELETE));
    }

    @Test
    void getActiveUsers() {
        var requestMethodCounted = report.getActiveUsers(3);
        assertEquals(3, requestMethodCounted.size());
        assertEquals(4, requestMethodCounted.get("217.168.17.5"));
        assertEquals(3, requestMethodCounted.get("93.180.71.3"));
        assertEquals(2, requestMethodCounted.get("80.91.33.133"));
    }

    @Test
    void getSizeInAverage() {
        assertEquals(160, report.getSizeInAverage());
    }
}
