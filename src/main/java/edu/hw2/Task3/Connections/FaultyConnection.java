package edu.hw2.Task3.Connections;

public class FaultyConnection extends ConnectionSimulation {
    public static final double PROBABILITY_OF_EXCEPTION = 0.3;

    @Override public double getProbabilityOfException() {
        return PROBABILITY_OF_EXCEPTION;
    }
}
