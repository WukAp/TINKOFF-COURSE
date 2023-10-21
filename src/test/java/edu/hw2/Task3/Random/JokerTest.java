package edu.hw2.Task3.Random;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JokerTest {

    @Test void shouldItFail() {
        Joker jokerAlwaysSuccess = new Joker(0);
        Joker jokerAlwaysFail = new Joker(1);
        assertTrue(jokerAlwaysFail.shouldItFail());
        assertFalse(jokerAlwaysSuccess.shouldItFail());
    }

    @Test void shouldItFailException() {
        assertThrows(IllegalArgumentException.class, () -> new Joker(-1));
        assertThrows(IllegalArgumentException.class, () -> new Joker(2));
        assertThrows(IllegalArgumentException.class, () -> new Joker(100));
    }
}
