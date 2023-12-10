package edu.hw2.Task2;

import java.util.Objects;

/**
 * Represents a Rectangle
 */
public class Rectangle {
    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("side should be positive");
        }
        this.width = width;
        this.height = height;
    }

    /**
     * creates a triangle with a new maxX
     *
     * @param width the new side
     * @return the new Rectangle with changed maxX
     */
    public Rectangle setWidth(int width) {
        return new Rectangle(width, this.height);
    }

    /**
     * creates a triangle with a new maxY
     *
     * @param height the new side
     * @return the new Rectangle with changed maxY
     */
    public Rectangle setHeight(int height) {
        return new Rectangle(this.width, height);
    }

    /**
     * calculates the area of a rectangle
     *
     * @return the area
     */
    public double area() {
        return width * height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "maxX=" + width + ", maxY=" + height + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }
}
