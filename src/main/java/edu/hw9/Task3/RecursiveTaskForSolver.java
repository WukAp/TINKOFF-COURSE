package edu.hw9.Task3;

import edu.project2.models.Coordinate;
import edu.project2.models.Direction;
import edu.project2.models.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskForSolver extends RecursiveTask<List<Coordinate>> {

    private final Coordinate start;
    private final Coordinate end;
    private final Direction parentDirection;
    private final Maze.Cell[][] grid;

    public RecursiveTaskForSolver(Coordinate start, Coordinate end, Direction parentDirection, Maze.Cell[][] grid) {
        this.start = start;
        this.end = end;
        this.parentDirection = parentDirection;
        this.grid = grid;
    }

    @Override
    protected List<Coordinate> compute() {

        if (start.equals(end)) {
            return new CopyOnWriteArrayList<>(Collections.singleton(start));
        }
        List<RecursiveTaskForSolver> solvedTasks = new ArrayList<>();

        for (Direction direction : Direction.values()) {
            Coordinate newCoordinate = start.calculateNewCoordinate(direction);
            if (direction != parentDirection && grid[newCoordinate.row()][newCoordinate.col()] == Maze.Cell.PASSAGE) {
                solvedTasks.addFirst(new RecursiveTaskForSolver(newCoordinate, end, direction.getReverse(), grid));
                solvedTasks.getFirst().fork();
            }
        }

        var results = solvedTasks.stream().map(ForkJoinTask::join).toList();
        for (var result : results) {
            if (result != null) {
                result.addFirst(start);
                return result;
            }
        }

        return null;
    }

}
