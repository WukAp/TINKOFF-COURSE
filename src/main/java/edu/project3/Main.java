package edu.project3;

import edu.project3.models.Format;
import edu.project3.parsers.LogRecordFilter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    private static final String PATH_PARAMETER = "--path";
    private static final String DATE_FROM_PARAMETER = "--from";
    private static final String DATE_TO_PARAMETER = "--to";
    private static final String FORMAT_PARAMETER = "--format";

    private Main() {
    }

    public static void main(String[] args) throws IOException {
        var listArgs = Arrays.stream(args).toList();
        String path = listArgs.get(listArgs.indexOf(PATH_PARAMETER) + 1);
        LogRecordFilter filter = new LogRecordFilter.EmptyConditionalFilter();

        if (listArgs.contains(DATE_FROM_PARAMETER)) {
            LocalDate startDate = LocalDate.parse(listArgs.get(listArgs.indexOf(DATE_FROM_PARAMETER) + 1));
            filter.add(new LogRecordFilter.FilterWithFromDate(startDate));
        }

        if (listArgs.contains(DATE_TO_PARAMETER)) {
            LocalDate endDate = LocalDate.parse(listArgs.get(listArgs.indexOf(DATE_TO_PARAMETER) + 1));
            filter.add(new LogRecordFilter.FilterWithToDate(endDate));
        }

        Format format;
        if (listArgs.contains(FORMAT_PARAMETER)) {
            format = Format.getFormat(listArgs.get(listArgs.indexOf(FORMAT_PARAMETER) + 1));
        } else {
            format = Format.ADOC;
        }
        Controller controller = new Controller(path, filter, format);
        controller.run();
    }
}
