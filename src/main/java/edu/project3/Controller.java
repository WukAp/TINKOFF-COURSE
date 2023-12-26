package edu.project3;

import edu.project3.downloading.LogsDownloader;
import edu.project3.downloading.LogsDownloaderAdoc;
import edu.project3.downloading.LogsDownloaderMarkdown;
import edu.project3.models.Format;
import edu.project3.models.LogRecord;
import edu.project3.parsers.LogRecordFilter;
import edu.project3.parsers.LogsParserFromFile;
import edu.project3.parsers.LogsParserFromURL;
import edu.project3.report.LogReport;
import java.io.IOException;
import java.util.List;

public class Controller {
    private static final String DEFAULT_PATH_NAME = "src/main/resources/project3/Result/report";
    private final String path;
    private final LogRecordFilter filter;
    private final Format format;

    public Controller(String path, LogRecordFilter filter, Format format) {
        this.path = path;
        this.filter = filter;
        this.format = format;
    }

    public void run() throws IOException {
        LogReport report = new LogReport(getLogs());
        LogsDownloader downloader =
            switch (format) {
                case ADOC -> new LogsDownloaderAdoc(report);
                case MARKDOWN -> new LogsDownloaderMarkdown(report);
            };
        downloader.download(DEFAULT_PATH_NAME);
    }

    private List<LogRecord> getLogs() throws IOException {
        if (path.contains("://")) {
            return new LogsParserFromURL(path, filter).getLogReports();
        } else {
            return new LogsParserFromFile(path, filter).getLogReports();
        }
    }
}
