package edu.project1;

import edu.project1.GuessResult.Defeat;
import edu.project1.GuessResult.FailedGuess;
import edu.project1.GuessResult.SuccessfulGuess;
import edu.project1.GuessResult.Win;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SessionTest {

    @Test void guessWin() {
        Session session = new Session("dog", 2);
        GuessResult success1 = session.guess('d');
        GuessResult fail = session.guess('e');
        GuessResult success2 = session.guess('o');
        GuessResult win = session.guess('g');

        assertEquals(SuccessfulGuess.class, success1.getClass());
        assertEquals(SuccessfulGuess.class, success2.getClass());
        assertEquals(FailedGuess.class, fail.getClass());
        assertEquals(Win.class, win.getClass());
    }

    @Test void guessDefeat() {
        Session session = new Session("dog", 2);
        GuessResult success = session.guess('d');
        GuessResult fail1 = session.guess('e');
        GuessResult fail2 = session.guess('f');
        GuessResult defeat = session.guess('a');

        assertEquals(SuccessfulGuess.class, success.getClass());
        assertEquals(FailedGuess.class, fail1.getClass());
        assertEquals(FailedGuess.class, fail2.getClass());
        assertEquals(Defeat.class, defeat.getClass());
    }

    @Test void giveUp() {
        Session session = new Session("dog", 2);
        assertEquals(Defeat.class, session.giveUp().getClass());
    }

    @Test void validateException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Session("dog", -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Session("dog", 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Session("dog222", 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Session("_22", 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Session("собакаdog", 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Session("", 2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Session(null, 2);
        });
    }
}
