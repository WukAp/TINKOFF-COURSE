package edu.hw5.Task3.Parsers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShortEuroFormatParser implements DateParser {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("d/M/yy");
    private static final String DATA_REG_EXP = "^\\d{1,2}/\\d{1,2}/(\\d{2})$";

    @Override
    public LocalDate parse(String string) {
        if (!isMatch(string)) {
            throw new IllegalArgumentException("Can't find pattern d/M/yy");
        }
        return LocalDate.parse(string, FORMATTER);
    }

    @Override
    public String getRegExp() {
        return DATA_REG_EXP;
    }
}
