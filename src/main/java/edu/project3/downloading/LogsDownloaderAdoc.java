package edu.project3.downloading;

import edu.project3.report.LogReport;
import java.util.List;
import java.util.stream.Collectors;

public class LogsDownloaderAdoc extends LogsDownloader {
    private static final String TABLE_OPTIONS = "[options=\"header]" + System.lineSeparator();
    private static final String TABLE_ROW_SPLITERATOR = "|===" + System.lineSeparator();
    private static final String TABLE_COLUMN_SPLITERATOR = "|";

    public LogsDownloaderAdoc(LogReport report) {
        super(report);
    }

    @Override
    protected String makeTable(List<List<String>> body, List<String> headers) {
        if (!body.isEmpty() && headers.size() != body.getFirst().size()) {
            throw new IllegalArgumentException("headers number should be equals column number");
        }
        StringBuilder table = new StringBuilder(TABLE_OPTIONS).append(TABLE_ROW_SPLITERATOR);

        table.append(getRow(headers));
        for (List<String> row : body) {
            table.append(getRow(row));
        }
        table.append(TABLE_ROW_SPLITERATOR);
        return String.valueOf(table);
    }

    private String getRow(List<String> rowData) {
        return rowData.stream().collect(Collectors.joining(
            TABLE_COLUMN_SPLITERATOR,
            TABLE_COLUMN_SPLITERATOR,
            System.lineSeparator()
        ));
    }

    @Override
    protected String getFileExtension() {
        return ".adoc";
    }
}
