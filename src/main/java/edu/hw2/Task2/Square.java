package edu.hw2.Task2;

/**
 * Represents a Square
 */
public class Square extends Rectangle {
    /**
     * creates a triangle with a new maxX
     *
     * @param side the new side
     * @return the new Square with changed sides
     */
    public Square setSide(int side) {
        return new Square(side);
    }

    @Override
    public String toString() {
        return "Square{" + "side=" + super.getWidth() + '}';
    }

    public Square(int side) {
        super(side, side);
    }
}
