package edu.project2.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {

    @Test
    void row() {
        Coordinate coordinate = new Coordinate(10, 20);
        Assertions.assertEquals(10, coordinate.row());
    }

    @Test
    void col() {
        Coordinate coordinate = new Coordinate(10, 20);
        Assertions.assertEquals(20, coordinate.col());
    }

    @Test
    void exceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinate(-10, 20));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinate(-10, -20));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Coordinate(-10, -20));
    }

    @Test
    void testEquals() {
        Coordinate coordinate = new Coordinate(1, 1);
        assertEquals(coordinate, coordinate);
        assertEquals(new Coordinate(1, 1), new Coordinate(1, 1));
        assertNotEquals(new Coordinate(1, 1), new Coordinate(1, 2));
        assertNotEquals(new Coordinate(1, 1), new Object());
        assertNotEquals(new Coordinate(1, 1), null);
    }

    @Test
    void testHashCode() {
        Coordinate coordinate = new Coordinate(1, 1);
        assertEquals(coordinate.hashCode(), coordinate.hashCode());
        assertEquals(new Coordinate(1, 1).hashCode(), new Coordinate(1, 1).hashCode());
    }
}
