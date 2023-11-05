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
}
