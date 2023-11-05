package edu.project2.views;

import edu.project2.models.Coordinate;
import edu.project2.models.Maze;
import java.util.List;

public interface Renderer {
    String render(Maze maze);

    String render(Maze maze, List<Coordinate> path);
}
