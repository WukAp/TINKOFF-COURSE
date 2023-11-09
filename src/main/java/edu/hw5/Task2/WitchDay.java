package edu.hw5.Task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.Year;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.LinkedList;
import java.util.List;

public class WitchDay {
    private static final int MONTH_AMOUNT = 12;
    private static final int WITCH_DATE = 13;
    private static final DayOfWeek WITCH_DAY_OF_WEEK = DayOfWeek.FRIDAY;

    /**
     * finds all witch days of the year
     *
     * @param year the year in which needs to find the WitchDays
     * @return the list of all WitchDay of the year
     */
    public List<LocalDate> getWitchDaysByYear(Year year) {
        List<LocalDate> witchDays = new LinkedList<>();
        for (int month = 1; month <= MONTH_AMOUNT; month++) {
            LocalDate witchDateInCurrentMonth = (year.atMonthDay(MonthDay.of(month, WITCH_DATE)));
            if (witchDateInCurrentMonth.getDayOfWeek() == WITCH_DAY_OF_WEEK) {
                witchDays.add(witchDateInCurrentMonth);
            }
        }
        return witchDays;
    }

    public Temporal getNextWitchDay(LocalDate localDate) {
        Temporal nextWitchDay = localDate;
        do {
            nextWitchDay = nextWitchDay.with(TemporalAdjusters.next(WITCH_DAY_OF_WEEK));
        } while (nextWitchDay.get(ChronoField.DAY_OF_MONTH) != WITCH_DATE);
        return nextWitchDay;
    }
}
