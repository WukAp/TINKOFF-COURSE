package edu.hw9.Task3;

import edu.project2.models.Coordinate;
import edu.project2.models.Direction;
import edu.project2.models.Maze;
import edu.project2.solvers.Solver;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class BacktrackingSolverAsync implements Solver {
    private Maze.Cell[][] grid;

    @Override
    public List<Coordinate> solve(final Maze maze, Coordinate start, Coordinate end) {
        this.grid = maze.grid();
        if (grid[start.row()][start.col()] == Maze.Cell.WALL || grid[end.row()][end.col()] == Maze.Cell.WALL) {
            throw new IllegalArgumentException();
        }

        RecursiveTaskForSolver recursiveTask = new RecursiveTaskForSolver(start, end, Direction.LEFT, grid);

        try (ForkJoinPool forkJoinPool = new ForkJoinPool()) {
            return forkJoinPool.invoke(recursiveTask);
        }

    }
}
