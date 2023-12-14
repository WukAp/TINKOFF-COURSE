package edu.project4.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PixelTest {

    @Test
    void getPixelWithIncrementedHitCount() {
        Pixel pixel = new Pixel(new Color(1, 2, 3), 10).getPixelWithIncrementedHitCount();

        assertEquals(new Color(1, 2, 3), pixel.color());
        assertEquals(11, pixel.hitCount());


        pixel = pixel.getPixelWithIncrementedHitCount();
        assertEquals(new Color(1, 2, 3), pixel.color());
        assertEquals(12, pixel.hitCount());
    }
    @Test
    void getters() {

        Pixel pixel = new Pixel(new Color(1, 2, 3), 10);
        assertEquals(new Color(1, 2, 3), pixel.color());
        assertEquals(10, pixel.hitCount());
    }
}
