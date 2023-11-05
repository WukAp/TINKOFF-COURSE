package edu.project2.generators;


import edu.project2.models.Coordinate;
import edu.project2.models.Direction;
import edu.project2.models.Maze;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import static edu.project2.models.Maze.Cell;
import static edu.project2.models.Maze.Cell.PASSAGE;
import static edu.project2.models.Maze.Cell.WALL;

public class BacktrackingGenerator implements Generator {
    private Cell[][] grid;
    private int height;
    private int width;
    private final Random random = new Random();

    @Override
    public Maze generate(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException("maze sides should be positive");
        }
        this.height = height;
        this.width = width;
        this.grid = getMazeFilledWalls(height, width);
        backtracking(new Coordinate(1, 1));
        return new Maze(height, width, grid);
    }

    private void backtracking(Coordinate coordinate) {
        grid[coordinate.row()][coordinate.col()] = PASSAGE;
        Queue<Coordinate> backtrackingQueue = new LinkedList<>(List.of(coordinate));

        while (!backtrackingQueue.isEmpty()) {
            Coordinate currentCoordinate = backtrackingQueue.poll();
            List<Coordinate> availableCoordinates = new LinkedList<>();
            for (Direction direction : Direction.values()) {
                Coordinate newCoordinate = currentCoordinate.calculateNewCoordinate(direction);
                if (isValid(newCoordinate, direction.getReverse())) {
                    availableCoordinates.add(newCoordinate);
                }
            }
            if (availableCoordinates.isEmpty()) {
                continue;
            }
            Coordinate newCoordinate = availableCoordinates.get(random.nextInt(availableCoordinates.size()));
            grid[newCoordinate.row()][newCoordinate.col()] = PASSAGE;

            backtrackingQueue.add(newCoordinate);
            if (availableCoordinates.size() > 1) {
                backtrackingQueue.add(currentCoordinate);
            }
        }
    }

    private Cell[][] getMazeFilledWalls(int height, int width) {
        Cell[][] gridFilledWalls = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridFilledWalls[i][j] = WALL;
            }
        }
        return gridFilledWalls;
    }

    private boolean isValid(Coordinate coordinate, Direction parentDirection) {
        if (coordinate.col() <= 0
            || coordinate.col() >= width - 1
            || coordinate.row() <= 0
            || coordinate.row() >= height - 1) {
            return false;
        }
        if (grid[coordinate.row()][coordinate.col()] == PASSAGE) {
            return false;
        }
        for (var direction : Direction.values()) {
            if (direction != parentDirection) {
                int x = coordinate.row() + direction.getStep()[0];
                int y = coordinate.col() + direction.getStep()[1];
                if (grid[x][y] == PASSAGE) {
                    return false;
                }

            }
        }
        return true;
    }
}
