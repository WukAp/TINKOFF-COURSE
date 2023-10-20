package edu.project1;

import edu.project1.GuessResult.Defeat;
import edu.project1.GuessResult.FailedGuess;
import edu.project1.GuessResult.SuccessfulGuess;
import edu.project1.GuessResult.Win;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GuessResultTest {

    @Test void message() {

        char[] state = new char[] {'*', '*', '*'};
        assertEquals("You won! The word: " + new String(state), new Win(state).message());
        assertEquals("You lost!", new Defeat().message());
        assertEquals("Missed, mistake " + 1 + " out of " + 1, new FailedGuess(state, 1, 1).message());
        assertEquals("Hit! The word: " + new String(state), new SuccessfulGuess(state).message());
    }

    @Test void isGameOver() {
        char[] state = new char[] {'*', '*', '*'};
        assertTrue(new Win(state).isGameOver());
        assertTrue(new Defeat().isGameOver());
        assertFalse(new FailedGuess(state, 1, 1).isGameOver());
        assertFalse(new SuccessfulGuess(state).isGameOver());
    }
}
