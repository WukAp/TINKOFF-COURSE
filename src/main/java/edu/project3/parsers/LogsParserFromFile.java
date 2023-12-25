package edu.project3.parsers;

import edu.project3.models.LogRecord;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogsParserFromFile extends LogsParser {

    private final static Logger LOGGER = LogManager.getLogger();
    private final List<LogRecord> logReports = new ArrayList<>();

    public LogsParserFromFile(String pathTemplate) throws IOException {
        this(pathTemplate, new LogRecordFilter.EmptyConditionalFilter());
    }

    public LogsParserFromFile(String pathTemplate, LogRecordFilter filter) throws IOException {
        String rootDirectory;
        String pathTemplateBuffer = pathTemplate;
        if (pathTemplateBuffer.startsWith(File.separator)) {
            rootDirectory = File.separator;
        } else {
            rootDirectory = System.getProperty("user.dir");
            pathTemplateBuffer = rootDirectory + File.separator + pathTemplateBuffer;

        }
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + pathTemplateBuffer);
        Files.walk(Paths.get(rootDirectory))
            .filter(pathMatcher::matches)
            .forEach(path -> parseFromFile(path, filter));
    }

    @Override
    public List<LogRecord> getLogReports() {
        return logReports;
    }

    private boolean parseFromFile(Path path, LogRecordFilter filter) {
        try {
            List<LogRecord> logReportsBuf = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
            String line;
            while ((line = reader.readLine()) != null) {
                LogRecord parsedRecord = LogRecord.parseLogRecord(line);
                if (filter.isRequired(parsedRecord)) {
                    logReportsBuf.add(parsedRecord);
                }
            }
            reader.close();
            logReports.addAll(logReportsBuf);
            LOGGER.info("The file " + path + " was parsed");
            return true;
        } catch (IOException e) {
            LOGGER.error("Can' t parse the file " + path);
            return false;
        }
    }
}
