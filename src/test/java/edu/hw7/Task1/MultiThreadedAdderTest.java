package edu.hw7.Task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiThreadedAdderTest {
    private final MultiThreadedAdder multiThreadedAdder = new MultiThreadedAdder();

    @Test
    void getCount() throws InterruptedException {
        assertDoesNotThrow(() -> multiThreadedAdder.add(1000));
        assertEquals(1000, multiThreadedAdder.getCount().get());
        assertDoesNotThrow(() -> multiThreadedAdder.add(2000));
        assertEquals(3000, multiThreadedAdder.getCount().get());
    }
}
