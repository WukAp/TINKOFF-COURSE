package edu.hw5.Task3.Parsers;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RelativeDaysParser implements DateParser {
    private static final String DATA_REG_EXP = "^(\\d+) days? ago$";

    @Override
    public LocalDate parse(String string) {
        Matcher matcher = Pattern.compile(DATA_REG_EXP).matcher(string);
        if (matcher.find()) {
            return LocalDate.now().minusDays(Long.parseLong(matcher.group(1)));
        }
        throw new IllegalArgumentException("Can't find pattern");
    }

    @Override
    public String getRegExp() {
        return DATA_REG_EXP;
    }
}
