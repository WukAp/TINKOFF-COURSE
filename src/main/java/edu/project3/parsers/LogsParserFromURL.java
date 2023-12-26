package edu.project3.parsers;

import edu.project3.models.LogRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LogsParserFromURL extends LogsParser {
    private final List<LogRecord> logReports = new ArrayList<>();

    public LogsParserFromURL(String path) throws MalformedURLException {
        this(path, new LogRecordFilter.EmptyConditionalFilter());
    }

    public LogsParserFromURL(String path, LogRecordFilter filter) throws MalformedURLException {
        URL url = new URL(path);
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                LogRecord parsedRecord = LogRecord.parseLogRecord(line);
                if (filter.isRequired(parsedRecord)) {
                    logReports.add(parsedRecord);
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't read file from Url " + url);
        }
    }

    @Override
    public List<LogRecord> getLogReports() {
        return logReports;
    }
}
