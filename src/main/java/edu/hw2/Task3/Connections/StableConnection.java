package edu.hw2.Task3.Connections;

public class StableConnection extends ConnectionSimulation {
    public static final double PROBABILITY_OF_EXCEPTION = 0;

    @Override public double getProbabilityOfException() {
        return PROBABILITY_OF_EXCEPTION;
    }
}
