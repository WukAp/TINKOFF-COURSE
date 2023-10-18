package edu.hw2.Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SquareTest {

    @Test void setSide() {
        Square square = new Square(1);
        Assertions.assertEquals(new Square(5), square.setSide(5));
        Assertions.assertEquals(new Square(51), square.setSide(51));
        Assertions.assertEquals(new Square(15), square.setSide(15));
        Assertions.assertEquals(new Square(1), square.setSide(1));
        Assertions.assertEquals(new Square(1), square.setSide(1));
    }

    @Test void setWidth() {
        Rectangle rectangle = new Square(5);
        Assertions.assertEquals(new Rectangle(10, 5), rectangle.setWidth(10));
        Assertions.assertEquals(new Rectangle(5, 5), rectangle.setWidth(5));
        Assertions.assertEquals(new Rectangle(100, 5), rectangle.setWidth(100));
        Assertions.assertEquals(new Rectangle(1, 5), rectangle.setWidth(1));
    }

    @Test void setHeight() {
        Rectangle rectangle = new Square(5);
        Assertions.assertEquals(new Rectangle(5, 10), rectangle.setHeight(10));
        Assertions.assertEquals(new Rectangle(5, 1), rectangle.setHeight(1));
        Assertions.assertEquals(new Rectangle(5, 100), rectangle.setHeight(100));
    }

    @Test void rectangleExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Square(-10));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Square(0));
    }

    @Test void setSideExceptions() {
        Square square = new Square(1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> square.setSide(-5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> square.setSide(0));
    }

}
