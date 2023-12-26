package edu.hw9.Task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatInfoTest {

    private final StatInfo statInfo = new StatInfo(0.3, 0.2, 0.0, 0.1, 10, -10);
    private final double eps = 0.00001;

    @Test
    void getMax() {
        assertEquals(10, statInfo.getMax());
    }

    @Test
    void getMin() {
        assertEquals(-10, statInfo.getMin());
    }

    @Test
    void getAverage() {
        assertTrue(Math.abs(0.1 - statInfo.getAverage()) < eps);
    }

    @Test
    void getSum() {
        assertTrue(Math.abs(0.6 - statInfo.getSum()) < eps);
    }
}
