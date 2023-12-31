package edu.project2.solvers;

import edu.project2.models.Coordinate;
import edu.project2.models.Maze;
import java.util.List;

public interface Solver {
    List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end);
}
