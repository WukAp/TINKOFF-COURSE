package edu.project2.generators;

import edu.project2.models.Maze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BacktrackingGeneratorTest {

    @Test
    void generate() {
        Generator generator = new BacktrackingGenerator();
        Maze maze = generator.generate(10, 20);
        Assertions.assertEquals(10, maze.height());
        Assertions.assertEquals(20, maze.width());
    }

    @Test
    void generateExceptions() {
        Generator generator = new BacktrackingGenerator();
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(-10, 20));
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(10, -20));
        Assertions.assertThrows(IllegalArgumentException.class, () -> generator.generate(-10, -20));
    }
}
