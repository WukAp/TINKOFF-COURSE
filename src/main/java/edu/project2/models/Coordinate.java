package edu.project2.models;

import java.util.Objects;

public record Coordinate(int row, int col) {
    public Coordinate {
        if (row < 0 || col < 0) {
            throw new IllegalArgumentException();
        }
    }

    public Coordinate calculateNewCoordinate(Direction direction) {
        int x = this.row() + direction.getStep()[0];
        int y = this.col() + direction.getStep()[1];
        return new Coordinate(x, y);
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinate that = (Coordinate) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
