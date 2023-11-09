package edu.hw5.Task2;

import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WitchDayTest {
    private final WitchDay witchDay = new WitchDay();

    @Test
    void getWitchDaysByYear() {
        Assertions.assertArrayEquals(new LocalDate[] {
            LocalDate.parse("1925-02-13"),
            LocalDate.parse("1925-03-13"),
            LocalDate.parse("1925-11-13")
        }, witchDay.getWitchDaysByYear(Year.of(1925)).toArray());

        Assertions.assertArrayEquals(new LocalDate[] {
            LocalDate.parse("2024-09-13"),
            LocalDate.parse("2024-12-13")
        }, witchDay.getWitchDaysByYear(Year.of(2024)).toArray());

    }

    @Test
    void getNextWitchDay() {
        Assertions.assertEquals(LocalDate.parse("1925-02-13"), witchDay.getNextWitchDay(LocalDate.parse("1925-01-13")));
        Assertions.assertEquals(LocalDate.parse("1925-03-13"), witchDay.getNextWitchDay(LocalDate.parse("1925-02-13")));
        Assertions.assertEquals(LocalDate.parse("1925-02-13"), witchDay.getNextWitchDay(LocalDate.parse("1924-12-13")));
        Assertions.assertEquals(LocalDate.parse("2024-09-13"), witchDay.getNextWitchDay(LocalDate.parse("2024-01-10")));
        Assertions.assertEquals(LocalDate.parse("2024-12-13"), witchDay.getNextWitchDay(LocalDate.parse("2024-09-14")));
    }
}
