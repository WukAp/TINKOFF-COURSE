package edu.hw7.Task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ParallelFactorialTest {
    private final ParallelFactorial parallelFactorial = new ParallelFactorial();
    @Test
    void getFactorial() {
        assertEquals(1, parallelFactorial.getFactorial(1));
        assertEquals(2, parallelFactorial.getFactorial(2));
        assertEquals(6, parallelFactorial.getFactorial(3));
        assertEquals(120, parallelFactorial.getFactorial(5));
        assertEquals(40320, parallelFactorial.getFactorial(8));
        assertEquals(3628800, parallelFactorial.getFactorial(10));
    }
}
