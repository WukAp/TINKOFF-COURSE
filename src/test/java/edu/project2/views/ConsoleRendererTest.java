package edu.project2.views;

import edu.project2.models.Coordinate;
import edu.project2.models.Maze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import static edu.project2.models.Maze.Cell.PASSAGE;
import static edu.project2.models.Maze.Cell.WALL;

class ConsoleRendererTest {

    @Test
    void render() {
        ConsoleRenderer consoleRenderer = new ConsoleRenderer();
        Maze maze = new Maze(4, 4, new Maze.Cell[][] {
            {PASSAGE, PASSAGE, WALL, WALL},
            {WALL, PASSAGE, PASSAGE, PASSAGE},
            {WALL, PASSAGE, PASSAGE, PASSAGE},
            {WALL, WALL, WALL, WALL}
        });
        Assertions.assertEquals("  ▆▆\n▆   \n▆   \n▆▆▆▆\n", consoleRenderer.render(maze));
    }

    @Test
    void testRender() {
        ConsoleRenderer consoleRenderer = new ConsoleRenderer();
        Maze maze = new Maze(4, 4, new Maze.Cell[][] {
            {PASSAGE, PASSAGE, WALL, WALL},
            {WALL, PASSAGE, PASSAGE, PASSAGE},
            {WALL, PASSAGE, PASSAGE, PASSAGE},
            {WALL, WALL, WALL, WALL}
        });
        List<Coordinate> path = List.of(new Coordinate(0, 0), new Coordinate(0, 1),
            new Coordinate(1, 1), new Coordinate(2, 1),
            new Coordinate(2, 2), new Coordinate(2, 3)
        );
        Assertions.assertEquals("☺·▆▆\n▆·  \n▆··⚑\n▆▆▆▆\n", consoleRenderer.render(maze, path));
    }
}
