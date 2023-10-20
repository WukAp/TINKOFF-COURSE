package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final Random random = new Random();
    public static final double PROBABILITY_OF_STABLE = 0.7;

    /**
     * chooses the FaultyConnection or the StableConnection by random
     *
     * @return the FaultyConnection or the StableConnection
     */
    @Override public Connection getConnection() {
        if (random.nextDouble() > PROBABILITY_OF_STABLE) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
