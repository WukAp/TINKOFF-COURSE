package edu.project2.models;

import java.util.Arrays;
import java.util.List;

public record Maze(int height, int width, Cell[][] grid) {

    public Maze {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("maze sides should be positive");
        }
        if (grid == null || grid.length < height || Arrays.stream(grid).anyMatch(row -> row.length < width)) {
            throw new IllegalArgumentException("illegal grid value");
        }
    }

    @Override public Cell[][] grid() {
        return grid.clone();
    }

    public enum Cell {
        WALL, PASSAGE;
    }

    public void validatePath(List<Coordinate> path) {
        path.forEach(this::validatePathCoordinate);
    }

    private void validatePathCoordinate(Coordinate coordinate) {
        if (coordinate.col() >= width()
            || coordinate.row() >= height()
            || grid[coordinate.row()][coordinate.col()] == Cell.WALL) {
            throw new IllegalArgumentException();
        }
    }
}
