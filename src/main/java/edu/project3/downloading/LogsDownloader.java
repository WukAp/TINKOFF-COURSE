package edu.project3.downloading;

import edu.project3.report.LogReport;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public abstract class LogsDownloader {
    protected static final int DEFAULT_LIMIT = 3;
    private final LogReport report;

    public LogsDownloader(LogReport report) {
        this.report = report;
    }

    @SuppressWarnings("MultipleStringLiterals")
    public void download(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename + getFileExtension(), false)) {

            writer.write("Общая информация" + System.lineSeparator());
            writer.write(makeTable(
                List.of(
                    List.of("Количество запросов", String.valueOf(report.getLogsAmount())),
                    List.of("Средний размер ответа", String.valueOf(report.getSizeInAverage()))
                ), List.of("Метрика", "Значение")
            ));

            writer.write("Запрашиваемые ресурсы" + System.lineSeparator());
            writer.write(makeTable(
                report.getPopularRequestsURL(DEFAULT_LIMIT).entrySet().stream().map(
                    set -> List.of(Objects.toString(set.getKey()), Objects.toString(set.getValue()))).toList(),
                List.of("Ресурс", "Количество")
            ));

            writer.write("Коды ответов" + System.lineSeparator());
            writer.write(makeTable(
                report.getPopularCodes(DEFAULT_LIMIT).entrySet().stream().map(
                    set -> List.of(
                        Objects.toString(set.getKey().getCode()),
                        Objects.toString(set.getKey().getMessage()),
                        Objects.toString(set.getValue())
                    )).toList(),
                List.of("Код", "Имя", "Количество")
            ));

            writer.write("Запрашиваемые методы" + System.lineSeparator());
            writer.write(makeTable(
                report.getRequestMethodCounted().entrySet().stream().map(
                    set -> List.of(
                        Objects.toString(set.getKey()),
                        Objects.toString(set.getValue())
                    )).toList(),
                List.of("Метод", "Количество")
            ));

            writer.write("Пользователи" + System.lineSeparator());
            writer.write(makeTable(
                report.getActiveUsers(DEFAULT_LIMIT).entrySet().stream().map(
                    set -> List.of(
                        Objects.toString(set.getKey()),
                        Objects.toString(set.getValue())
                    )).toList(),
                List.of("Пользователь", "Количество")
            ));

            writer.flush();
        }
    }

    protected abstract String makeTable(List<List<String>> body, List<String> headers);

    protected abstract String getFileExtension();
}
