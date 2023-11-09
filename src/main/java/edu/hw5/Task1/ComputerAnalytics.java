package edu.hw5.Task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComputerAnalytics {
    private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, H:m");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("Hч mм");
    private static final String DATA_REG_EXP = "(\\d{4}-\\d{2}-\\d{2}, \\d{1,2}:\\d{1,2})";
    private static final String SEPARATOR = " - ";

    /**
     * calculate the time visitors spend time on average in one session
     *
     * @param sessionIntervals the list of strings like 2022-03-12, 20:20 - 2022-03-12, 23:50
     * @return the time on average in one session
     */
    public String prettyDurationOnAverage(List<String> sessionIntervals) {
        validateIsNotEmpty(sessionIntervals);

        long onAverageTime =
            (long) sessionIntervals.stream()
                .mapToLong(string -> getDurationByString(string).getSeconds())
                .average()
                .orElseThrow();

        return OUTPUT_FORMATTER.format(LocalTime.ofSecondOfDay(onAverageTime));
    }

    private Duration getDurationByString(String interval) {
        Matcher matcher = Pattern.compile(DATA_REG_EXP + SEPARATOR + DATA_REG_EXP).matcher(interval);
        if (!matcher.find()) {
            throw new IllegalArgumentException("Can't parse interval" + SEPARATOR);
        }
        LocalDateTime firstDate = LocalDateTime.parse(matcher.group(1), INPUT_FORMATTER);
        LocalDateTime secondDate = LocalDateTime.parse(matcher.group(2), INPUT_FORMATTER);
        return Duration.between(firstDate, secondDate);
    }

    private void validateIsNotEmpty(List<String> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("interval list shouldn't be empty");
        }
    }
}
