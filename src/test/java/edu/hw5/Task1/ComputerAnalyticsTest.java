package edu.hw5.Task1;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ComputerAnalyticsTest {
    private final ComputerAnalytics computerAnalytics = new ComputerAnalytics();

    @Test
    void prettyDurationOnAverage() {
        assertEquals("3ч 30м", computerAnalytics.prettyDurationOnAverage(List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50"
        )));
        assertEquals("3ч 40м", computerAnalytics.prettyDurationOnAverage(List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        )));
    }

    @Test
    void prettyDurationOnAverageExceptions() {
        assertThrows(IllegalArgumentException.class, () -> computerAnalytics.prettyDurationOnAverage(List.of(
            "2022-03-12, 20:20"
        )));
        assertThrows(IllegalArgumentException.class, () -> computerAnalytics.prettyDurationOnAverage(List.of(
            "2022-01, -0421:30 - 2022-04-02, 01:20"
        )));
        assertThrows(IllegalArgumentException.class, () -> computerAnalytics.prettyDurationOnAverage(null));
        assertThrows(IllegalArgumentException.class, () -> computerAnalytics.prettyDurationOnAverage(List.of()));
    }
}
