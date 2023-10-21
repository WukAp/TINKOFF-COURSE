package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsoleHangman {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final static Logger LOGGER = LogManager.getLogger();
    private final int maxAttempt;
    public static final String EXIT_COMMAND = "exit";

    public ConsoleHangman(Dictionary dictionary, int maxAttempt) {
        this.maxAttempt = maxAttempt;
        this.dictionary = dictionary;
        LOGGER.atDebug();
    }

    private final Dictionary dictionary;

    /**
     * runs the game loop
     */
    public void run() {
        LOGGER.info("Welcome to Console Hangman");
        Session session = new Session(dictionary.randomWord(), maxAttempt);
        GuessResult guessResult;
        do {
            Character letter = getGuessLetter();
            guessResult = tryGuess(session, letter);
            printState(guessResult);
        } while (!guessResult.isGameOver());
    }

    private GuessResult tryGuess(Session session, Character input) {
        if (input == null) {
            return session.giveUp();
        }
        return session.guess(input);
    }

    private void printState(GuessResult guess) {
        LOGGER.info(guess.message());
    }

    private Character getGuessLetter() {
        String inputString;
        do {
            LOGGER.info("Guess a letter:");
            inputString = SCANNER.nextLine();
            if (inputString.equals(EXIT_COMMAND)) {
                return null;
            }
        } while (!inputString.matches("[a-zA-Zа-яА-Я]"));
        return inputString.toLowerCase().charAt(0);
    }
}
