package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Random.Joker;

public class FaultyConnection extends ConnectionSimulation {

    public static final double DEFAULT_PROBABILITY_OF_EXCEPTION = 0.3;
    private final Joker joker;

    public FaultyConnection(Joker joker) {
        this.joker = joker;
    }

    public FaultyConnection() {
        this.joker = new Joker(DEFAULT_PROBABILITY_OF_EXCEPTION);
    }

    @Override
    boolean shouldItFail() {
        return joker.shouldItFail();
    }
}
