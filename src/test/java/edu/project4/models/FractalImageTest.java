package edu.project4.models;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class FractalImageTest {
    private final Color color = new Color(10, 10, 10);

    @Test
    void create() {
        FractalImage canvas = FractalImage.create(10, 20);
        assertEquals(10, canvas.width());
        assertEquals(20, canvas.height());

    }

    @Test
    void contains() {
        HashMap<Point, Pixel> map = new HashMap<>();
        map.put(new Point(0.5, 0), new Pixel(color, 1));
        map.put(new Point(0.5, 0.5), new Pixel(color, 1));
        map.put(new Point(0, 0), new Pixel(color, 1));

        FractalImage canvas = new FractalImage(map, 10, 20);
        assertTrue(canvas.contains(new Point(0.5, 0)));
        assertTrue(canvas.contains(new Point(0.5, 0.5)));
        assertTrue(canvas.contains(new Point(0, 0)));
        assertFalse(canvas.contains(new Point(0, -200)));
        assertFalse(canvas.contains(new Point(-100, 0)));
        assertFalse(canvas.contains(new Point(-100, -200)));
    }
    @Test
    void add() {
        FractalImage canvas = FractalImage.create(10, 20);
        assertTrue(canvas.add(new Point(0.5, 0), color));
        assertTrue(canvas.add(new Point(10, 0), color));
        assertFalse(canvas.add(new Point(100, 1), color));
        assertFalse(canvas.add(new Point(-1, 1), color));
        assertTrue(canvas.contains(new Point(0.5, 0)));
        assertTrue(canvas.contains(new Point(10, 0)));


        assertEquals(new Pixel(color, 1), canvas.pixel(new Point(10, 0)));
        assertTrue(canvas.add(new Point(10, 0), color));
        assertTrue(canvas.add(new Point(10, 0), color));
        assertTrue(canvas.contains(new Point(10, 0)));
        assertEquals(new Pixel(color, 3), canvas.pixel(new Point(10, 0)));
    }


    @Test
    void isCoordinateInGrid() {
        FractalImage canvas = FractalImage.create(10, 20);
        assertTrue(canvas.isCoordinateInGrid(new Point(0.5, 0)));
        assertTrue(canvas.isCoordinateInGrid(new Point(0.5, 0.5)));
        assertTrue(canvas.isCoordinateInGrid(new Point(0, 0)));
        assertFalse(canvas.isCoordinateInGrid(new Point(0, 200)));
        assertFalse(canvas.isCoordinateInGrid(new Point(-100, 0)));
        assertFalse(canvas.isCoordinateInGrid(new Point(100, -200)));

    }

    @Test
    void pixel() {
        HashMap<Point, Pixel> map = new HashMap<>();
        map.put(new Point(0.5, 0), new Pixel(color, 1));
        map.put(new Point(0.5, 0.5), new Pixel(color, 2));
        map.put(new Point(0, 0), new Pixel(color, 3));
        FractalImage canvas = new FractalImage(map, 10, 20);
        assertEquals(new Pixel(color, 1), canvas.pixel(new Point(0.5, 0)));
        assertEquals(new Pixel(color, 2), canvas.pixel(new Point(0.5, 0.5)));
        assertEquals(new Pixel(color, 3), canvas.pixel(new Point(0, 0)));

    }
}
