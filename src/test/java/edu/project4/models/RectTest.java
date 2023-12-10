package edu.project4.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectTest {

    @Test
    void contains() {
        Rect rect = new Rect(-1, 1, -1, 1);
        assertTrue(rect.contains(new Point(0.5, 0)));
        assertTrue(rect.contains(new Point(0.5, -0.5)));
        assertTrue(rect.contains(new Point(0, 0)));
        assertFalse(rect.contains(new Point(0, -20)));
        assertFalse(rect.contains(new Point(-100, 0)));
        assertFalse(rect.contains(new Point(-100, -20)));
    }

    @Test
    void getters() {
        Rect rect = new Rect(-1, 1, -2, 2);
        assertEquals(-1,rect.minX());
        assertEquals(1,rect.maxX());
        assertEquals(-2,rect.minY());
        assertEquals(2,rect.maxY());
    }
}
