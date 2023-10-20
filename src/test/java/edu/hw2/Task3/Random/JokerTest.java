package edu.hw2.Task3.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JokerTest {

    @Test
    void shouldItFail() {
        final int experience = 10000;

        Joker jokerAlwaysSuccess = new Joker(0);
        Joker jokerAlwaysFail = new Joker(1);
        for (int i = 0; i < experience; i++) {
            assertTrue(jokerAlwaysFail.shouldItFail());
            assertFalse(jokerAlwaysSuccess.shouldItFail());
        }
    }

    @Test
    void shouldItFailException() {
        assertThrows(IllegalArgumentException.class, () -> new Joker(-1));
        assertThrows(IllegalArgumentException.class, () -> new Joker(2));
        assertThrows(IllegalArgumentException.class, () -> new Joker(100));
    }
}
