package edu.hw2.Task3.Random;

import java.util.Random;

public class Joker {
    private final Random random = new Random();

    private final double probabilityOfException;

    public Joker(double probabilityOfException) {
        if (probabilityOfException < 0 || probabilityOfException > 1) {
            throw new IllegalArgumentException("probability should be in 0..1");
        }
        this.probabilityOfException = probabilityOfException;
    }

    /**
     * check if the action have been success or failed by random
     *
     * @return is random gets the "fail" result
     */
    public boolean shouldItFail() {
        return random.nextDouble() <= probabilityOfException;
    }
}
