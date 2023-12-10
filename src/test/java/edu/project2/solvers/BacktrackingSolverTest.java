package edu.project2.solvers;

import edu.project2.models.Coordinate;
import edu.project2.models.Maze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static edu.project2.models.Maze.Cell.WALL;
import static edu.project2.models.Maze.Cell.PASSAGE;

class BacktrackingSolverTest {
    Maze simpleMaze = new Maze(
        5,
        5,
        new Maze.Cell[][] {
            {WALL, WALL, WALL, WALL, WALL},
            {WALL, PASSAGE, PASSAGE, WALL, WALL},
            {WALL, WALL, WALL, WALL, WALL},
            {WALL, PASSAGE, WALL, WALL, WALL},
            {WALL, WALL, WALL, WALL, WALL}
        }
    );
    /*
▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆
▆      ▆ ▆  ▆▆▆
▆ ▆ ▆▆    ▆  ▆▆
▆ ▆   ▆▆▆  ▆  ▆
▆ ▆ ▆    ▆   ▆▆
▆  ▆ ▆ ▆▆ ▆▆  ▆
▆▆   ▆    ▆ ▆ ▆
▆▆ ▆ ▆ ▆▆    ▆▆
▆  ▆ ▆   ▆ ▆  ▆
▆ ▆   ▆▆ ▆ ▆▆ ▆
▆ ▆ ▆  ▆ ▆   ▆▆
▆ ▆ ▆ ▆   ▆▆  ▆
▆  ▆   ▆▆ ▆ ▆ ▆
▆▆ ▆ ▆  ▆   ▆ ▆
▆▆▆▆▆▆▆▆▆▆▆▆▆▆▆
     */
    Maze bigMaze = new Maze(
        15,
        15,
        new Maze.Cell[][] {{WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, PASSAGE, PASSAGE, PASSAGE, PASSAGE, PASSAGE, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, PASSAGE, WALL,
                WALL, WALL},
            {WALL, PASSAGE, WALL, PASSAGE, WALL, WALL, PASSAGE, PASSAGE, PASSAGE, PASSAGE, WALL, PASSAGE, PASSAGE, WALL,
                WALL},
            {WALL, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE, WALL, WALL, WALL, PASSAGE, PASSAGE, WALL, PASSAGE, PASSAGE,
                WALL},
            {WALL, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE,
                WALL, WALL},
            {WALL, PASSAGE, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, WALL, WALL, PASSAGE, WALL, WALL, PASSAGE, PASSAGE,
                WALL},
            {WALL, WALL, PASSAGE, PASSAGE, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE, PASSAGE, WALL, PASSAGE, WALL,
                PASSAGE, WALL},
            {WALL, WALL, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, WALL, WALL, PASSAGE, PASSAGE, PASSAGE, PASSAGE, WALL,
                WALL},
            {WALL, PASSAGE, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE, WALL, PASSAGE, WALL, PASSAGE,
                PASSAGE, WALL},
            {WALL, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE, WALL, WALL, PASSAGE, WALL, PASSAGE, WALL, WALL, PASSAGE,
                WALL},
            {WALL, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE, WALL,
                WALL},
            {WALL, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE, WALL, WALL, PASSAGE, PASSAGE,
                WALL},
            {WALL, PASSAGE, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE, WALL, WALL, PASSAGE, WALL, PASSAGE, WALL, PASSAGE,
                WALL},
            {WALL, WALL, PASSAGE, WALL, PASSAGE, WALL, PASSAGE, PASSAGE, WALL, PASSAGE, PASSAGE, PASSAGE, WALL, PASSAGE,
                WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}}
    );

    @Test
    void solve() {
        Solver solver = new BacktrackingSolver();
        Assertions.assertArrayEquals(
            new Coordinate[] {new Coordinate(1, 1), new Coordinate(1, 2)},
            solver.solve(simpleMaze, new Coordinate(1, 1), new Coordinate(1, 2)).toArray()
        );
        Assertions.assertNull(solver.solve(simpleMaze, new Coordinate(1, 1), new Coordinate(3, 1)));

        Assertions.assertArrayEquals(
            new Coordinate[] {new Coordinate(1, 2),
                new Coordinate(1, 3), new Coordinate(1, 4), new Coordinate(1, 5), new Coordinate(1, 6)},
            solver.solve(bigMaze, new Coordinate(1, 2), new Coordinate(1, 6)).toArray()
        );

        Assertions.assertArrayEquals(new Coordinate[] {new Coordinate(1, 2),
            new Coordinate(1, 3), new Coordinate(1, 4), new Coordinate(1, 5), new Coordinate(1, 6),
            new Coordinate(2, 6), new Coordinate(2, 7), new Coordinate(2, 8),
            new Coordinate(2, 9), new Coordinate(3, 9), new Coordinate(3, 10),
            new Coordinate(4, 10), new Coordinate(4, 11), new Coordinate(4, 12),
            new Coordinate(3, 12), new Coordinate(2, 12), new Coordinate(2, 11),
            new Coordinate(1, 11)}, solver.solve(bigMaze, new Coordinate(1, 2), new Coordinate(1, 11)).toArray());
    }

    @Test
    void solveExceptions() {
        Solver solver = new BacktrackingSolver();
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(bigMaze, new Coordinate(0, 0), new Coordinate(1, 3))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(bigMaze, new Coordinate(1, 3), new Coordinate(0, 0))
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> solver.solve(bigMaze, new Coordinate(0, 0), new Coordinate(0, 0))
        );
    }
}
