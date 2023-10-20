package edu.project1;

import edu.project1.GuessResult.Defeat;
import edu.project1.GuessResult.FailedGuess;
import edu.project1.GuessResult.SuccessfulGuess;
import edu.project1.GuessResult.Win;
import org.jetbrains.annotations.NotNull;

public class Session {
    private final String answer;
    private final char[] state;
    private final int maxAttempts;
    private int attempts;
    private int amountOfGuessed;

    public Session(String answer, int maxAttempts) {
        validate(answer, maxAttempts);
        this.answer = answer.toLowerCase();
        this.state = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            state[i] = '*';
        }
        this.maxAttempts = maxAttempts;
        amountOfGuessed = 0;
    }

    /**
     * checks if guess is right and if the game is over
     *
     * @param guess the suppose letter
     * @return the result of attempt
     */
    @NotNull GuessResult guess(char guess) {
        if (answer.indexOf(guess) == -1) {
            attempts++;
            if (attempts > maxAttempts) {
                return new Defeat();
            } else {
                return new FailedGuess(state, attempts, maxAttempts);
            }
        } else {
            updateState(guess);
            if (amountOfGuessed == answer.length()) {
                return new Win(state);
            } else {
                return new SuccessfulGuess(state);
            }
        }
    }

    /**
     * ends the game at the user's request
     * @return Defeat GameResult
     */
    @NotNull GuessResult giveUp() {
        return new Defeat();
    }

    private void updateState(char guess) {
        for (int i = answer.indexOf(guess); i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                state[i] = guess;
                amountOfGuessed++;
            }
        }
    }

    private void validate(String answer, int maxAttempts) {
        if (answer == null || answer.isBlank()) {
            throw new IllegalArgumentException("answer shouldn't be empty");
        }
        if (!(answer.matches("[a-zA-Z]+") || answer.matches("[а-яА-Я]+"))) {
            throw new IllegalArgumentException("answer should be a word");
        }
        if (maxAttempts <= 0) {
            throw new IllegalArgumentException("maxAttempts should be positive");
        }
    }
}
