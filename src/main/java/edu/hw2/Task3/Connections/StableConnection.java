package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Random.Joker;

public class StableConnection extends ConnectionSimulation {
    public static final double PROBABILITY_OF_EXCEPTION = 0;

    @Override boolean shouldItFail() {
        return new Joker(PROBABILITY_OF_EXCEPTION).shouldItFail();
    }
}
