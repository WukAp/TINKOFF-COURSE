package edu.project3.downloading;

import edu.project3.report.LogReport;
import java.util.List;
import java.util.stream.Collectors;

public class LogsDownloaderMarkdown extends LogsDownloader {

    private static final String TABLE_COLUMN_SPLITERATOR = "|";

    public LogsDownloaderMarkdown(LogReport report) {
        super(report);
    }

    @Override
    protected String makeTable(List<List<String>> body, List<String> headers) {
        if (!body.isEmpty() && headers.size() != body.getFirst().size()) {
            throw new IllegalArgumentException("headers number should be equals column number");
        }
        StringBuilder table = new StringBuilder(System.lineSeparator());

        table.append(getRow(headers));
        table.append(getHeaderBodySpliterator(headers.size()));
        for (List<String> row : body) {
            table.append(getRow(row));
        }

        return String.valueOf(table);
    }

    @Override
    protected String getFileExtension() {
        return ".md";
    }

    private String getRow(List<String> rowData) {
        return rowData.stream().collect(Collectors.joining(
            TABLE_COLUMN_SPLITERATOR,
            TABLE_COLUMN_SPLITERATOR,
            TABLE_COLUMN_SPLITERATOR + System.lineSeparator()
        ));
    }

    private String getHeaderBodySpliterator(int column) {
        return TABLE_COLUMN_SPLITERATOR + ("-" + TABLE_COLUMN_SPLITERATOR).repeat(column) + System.lineSeparator();
    }
}
