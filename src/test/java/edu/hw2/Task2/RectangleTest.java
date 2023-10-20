package edu.hw2.Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangleTest {

    @Test void setWidth() {
        Rectangle rectangle = new Rectangle(5, 5);
        Assertions.assertEquals(new Rectangle(10, 5), rectangle.setWidth(10));
        Assertions.assertEquals(new Rectangle(5, 5), rectangle.setWidth(5));
        Assertions.assertEquals(new Rectangle(100, 5), rectangle.setWidth(100));
        Assertions.assertEquals(new Rectangle(1, 5), rectangle.setWidth(1));
    }

    @Test void setHeight() {
        Rectangle rectangle = new Rectangle(5, 5);
        Assertions.assertEquals(new Rectangle(5, 10), rectangle.setHeight(10));
        Assertions.assertEquals(new Rectangle(5, 1), rectangle.setHeight(1));
        Assertions.assertEquals(new Rectangle(5, 100), rectangle.setHeight(100));
    }

    @Test void area() {
        Assertions.assertEquals(50, new Rectangle(10, 5).area());
        Assertions.assertEquals(500, new Rectangle(10, 50).area());
        Assertions.assertEquals(15, new Rectangle(3, 5).area());
        Assertions.assertEquals(10, new Rectangle(10, 1).area());
    }

    @Test void equals() {
        Rectangle rectangle = new Rectangle(15, 5);
        Assertions.assertEquals(rectangle, rectangle);

        Assertions.assertEquals(new Rectangle(15, 5), new Rectangle(15, 5));
        Assertions.assertEquals(new Rectangle(10, 5), new Rectangle(10, 5));
        Assertions.assertEquals(new Rectangle(10, 50), new Rectangle(10, 50));
        Assertions.assertNotEquals(new Rectangle(11, 50), new Rectangle(10, 50));
        Assertions.assertNotEquals(new Rectangle(11, 50), new Rectangle(11, 5));
        Assertions.assertNotEquals(new Rectangle(11, 50), new Square( 5));
        Assertions.assertNotEquals(null, new Rectangle(11, 5));
    }

    @Test void testHashCode() {
        Assertions.assertEquals(new Rectangle(10, 5).hashCode(), new Rectangle(10, 5).hashCode());
        Assertions.assertEquals(new Rectangle(15, 5).hashCode(), new Rectangle(15, 5).hashCode());
        Assertions.assertEquals(new Rectangle(10, 50).hashCode(), new Rectangle(10, 50).hashCode());
        Assertions.assertNotEquals(new Rectangle(11, 50).hashCode(), new Rectangle(10, 50).hashCode());
        Assertions.assertNotEquals(new Rectangle(11, 50).hashCode(), new Rectangle(11, 5).hashCode());
    }

    @Test void rectangleExceptions() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Rectangle(-10, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Rectangle(10, 0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Rectangle(-10, 0));
    }

    @Test void setWidthExceptions() {
        Rectangle rectangle = new Rectangle(5, 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> rectangle.setWidth(-5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> rectangle.setWidth(0));
    }

    @Test void setHeightExceptions() {
        Rectangle rectangle = new Rectangle(5, 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> rectangle.setHeight(-5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> rectangle.setHeight(0));
    }

    @Test void getWidth() {
        Assertions.assertEquals(1, new Rectangle(1, 5).getWidth());
        Assertions.assertEquals(10, new Rectangle(10, 50).getWidth());
        Assertions.assertEquals(3, new Rectangle(3, 5).getWidth());
        Assertions.assertEquals(5, new Rectangle(5, 1).getWidth());
    }

    @Test void getHeight() {
        Assertions.assertEquals(1, new Rectangle(15, 1).getHeight());
        Assertions.assertEquals(10, new Rectangle(15, 10).getHeight());
        Assertions.assertEquals(3, new Rectangle(15, 3).getHeight());
        Assertions.assertEquals(5, new Rectangle(15, 5).getHeight());
    }

    @Test void testToString() {
        Assertions.assertEquals("Rectangle{width=15, height=1}", new Rectangle(15, 1).toString());
        Assertions.assertEquals("Rectangle{width=10, height=5}", new Rectangle(10, 5).toString());
        Assertions.assertEquals("Rectangle{width=3, height=1}", new Rectangle(3, 1).toString());
    }
}
