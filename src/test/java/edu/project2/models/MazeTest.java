package edu.project2.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import static edu.project2.models.Maze.Cell.PASSAGE;
import static edu.project2.models.Maze.Cell.WALL;

class MazeTest {
    private final Maze testMaze1 = new Maze(4, 4, new Maze.Cell[][] {
        {PASSAGE, PASSAGE, WALL, WALL},
        {WALL, PASSAGE, PASSAGE, PASSAGE},
        {WALL, PASSAGE, PASSAGE, PASSAGE},
        {WALL, WALL, WALL, WALL}
    });
    private final Maze testMaze2 = new Maze(4, 3, new Maze.Cell[][] {
        {PASSAGE, PASSAGE, WALL},
        {WALL, PASSAGE, PASSAGE},
        {WALL, PASSAGE, PASSAGE},
        {WALL, WALL, WALL}
    });

    @Test
    void grid() {
        Assertions.assertArrayEquals(new Maze.Cell[][] {
            {PASSAGE, PASSAGE, WALL, WALL},
            {WALL, PASSAGE, PASSAGE, PASSAGE},
            {WALL, PASSAGE, PASSAGE, PASSAGE},
            {WALL, WALL, WALL, WALL}
        }, testMaze1.grid());
        Assertions.assertArrayEquals(new Maze.Cell[][] {
            {PASSAGE, PASSAGE, WALL},
            {WALL, PASSAGE, PASSAGE},
            {WALL, PASSAGE, PASSAGE},
            {WALL, WALL, WALL}
        }, testMaze2.grid());
    }

    @Test
    void validatePath() {
        List<Coordinate> path1 = List.of(new Coordinate(0, 0), new Coordinate(0, 1),
            new Coordinate(1, 1), new Coordinate(2, 1),
            new Coordinate(2, 2), new Coordinate(2, 3)
        );
        Assertions.assertDoesNotThrow(() -> testMaze1.validatePath(path1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> testMaze2.validatePath(path1));
    }

    @Test
    void height() {
        Assertions.assertEquals(4, testMaze1.height());
        Assertions.assertEquals(4, testMaze2.height());
    }

    @Test
    void width() {
        Assertions.assertEquals(4, testMaze1.width());
        Assertions.assertEquals(3, testMaze2.width());
    }

    @Test
    void constructorExceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Maze(4, 4, null)
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Maze(4, 4, new Maze.Cell[][] {
                {PASSAGE, PASSAGE},
                {WALL, PASSAGE}
            })
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Maze(4, 4, new Maze.Cell[][] {
                {PASSAGE, PASSAGE, PASSAGE, PASSAGE},
                {WALL, PASSAGE, PASSAGE, PASSAGE},
                {WALL, PASSAGE},
                {WALL, PASSAGE, PASSAGE, PASSAGE}
            })
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Maze(4, -4, new Maze.Cell[][] {
                {PASSAGE, PASSAGE, WALL, WALL},
                {WALL, PASSAGE, PASSAGE, PASSAGE},
                {WALL, PASSAGE, PASSAGE, PASSAGE},
                {WALL, WALL, WALL, WALL}
            })
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Maze(-4, 4, new Maze.Cell[][] {
                {PASSAGE, PASSAGE, WALL, WALL},
                {WALL, PASSAGE, PASSAGE, PASSAGE},
                {WALL, PASSAGE, PASSAGE, PASSAGE},
                {WALL, WALL, WALL, WALL}
            })
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> new Maze(0, 4, new Maze.Cell[][] {
                {PASSAGE, PASSAGE, WALL, WALL},
                {WALL, PASSAGE, PASSAGE, PASSAGE},
                {WALL, PASSAGE, PASSAGE, PASSAGE},
                {WALL, WALL, WALL, WALL}
            })
        );
    }
}
