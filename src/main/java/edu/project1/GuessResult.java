package edu.project1;

import org.jetbrains.annotations.NotNull;

public sealed interface GuessResult {

    @NotNull String message();

    boolean isGameOver();

    record Defeat() implements GuessResult {
        @Override public @NotNull String message() {
            return "You lost!";
        }

        @Override public boolean isGameOver() {
            return true;
        }
    }

    record Win(char[] state) implements GuessResult {
        @Override public @NotNull String message() {
            return "You won! The word: " + new String(state);
        }

        @Override public boolean isGameOver() {
            return true;
        }
    }

    record SuccessfulGuess(char[] state) implements GuessResult {
        @Override public @NotNull String message() {
            return "Hit! The word: " + new String(state);
        }

        @Override public boolean isGameOver() {
            return false;
        }
    }

    record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override public @NotNull String message() {
            return "Missed, mistake " + attempt + " out of " + maxAttempts;
        }

        @Override public boolean isGameOver() {
            return false;
        }
    }
}
