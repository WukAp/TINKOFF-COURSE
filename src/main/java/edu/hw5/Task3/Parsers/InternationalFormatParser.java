package edu.hw5.Task3.Parsers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InternationalFormatParser implements DateParser {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-d");
    private static final String DATA_REG_EXP = "^\\d{4}-\\d{1,2}-\\d{1,2}$";

    @Override
    public LocalDate parse(String string) {
        if (!isMatch(string)) {
            throw new IllegalArgumentException("Can't find pattern yyyy-M-d");
        }
        return LocalDate.parse(string, FORMATTER);
    }

    @Override
    public String getRegExp() {
        return DATA_REG_EXP;
    }

}
