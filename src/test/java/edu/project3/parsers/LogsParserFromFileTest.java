package edu.project3.parsers;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class LogsParserFromFileTest {

    @Test
    void constructors() {
        assertDoesNotThrow(() -> {
            new LogsParserFromFile("src/main/resources/project3/logs.txt");
        });
    }

    @Test
    void getLogReports() throws IOException {
        LogsParser logParser = new LogsParserFromFile("src/main/resources/project3/logs.txt");
        assertEquals(51462, logParser.getLogReports().size());

        logParser = new LogsParserFromFile("src/main/resources/project3/*.txt");
        assertEquals(51472, logParser.getLogReports().size());

        logParser = new LogsParserFromFile("src/main/resources/**");
        assertEquals(51472, logParser.getLogReports().size());
    }
}
