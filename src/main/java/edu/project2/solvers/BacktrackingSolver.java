package edu.project2.solvers;

import edu.project2.models.Coordinate;
import edu.project2.models.Direction;
import edu.project2.models.Maze;
import java.util.LinkedList;
import java.util.List;

public class BacktrackingSolver implements Solver {
    private Maze.Cell[][] grid;
    private int height;
    private int width;
    List<Coordinate> result;

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {

        this.height = maze.height();
        this.width = maze.width();
        this.grid = maze.grid();
        this.result = new LinkedList<>();
        if (grid[start.row()][start.col()] == Maze.Cell.WALL || grid[end.row()][end.col()] == Maze.Cell.WALL) {
            throw new IllegalArgumentException();
        }
        if (backtracking(start, end, Direction.LEFT)) {
            return result;
        }
        return null;
    }

    private boolean backtracking(Coordinate start, Coordinate end, Direction parentDirection) {
        if (start.equals(end)) {
            addInResult(start);
            return true;
        }

        for (Direction direction : Direction.values()) {
            Coordinate newCoordinate = start.calculateNewCoordinate(direction);
            if (direction != parentDirection && grid[newCoordinate.row()][newCoordinate.col()] == Maze.Cell.PASSAGE) {
                if (backtracking(newCoordinate, end, direction.getReverse())) {
                    addInResult(start);
                    return true;
                }
            }
        }
        return false;
    }

    private void addInResult(Coordinate coordinate) {
        result.add(0, coordinate);
    }
}
