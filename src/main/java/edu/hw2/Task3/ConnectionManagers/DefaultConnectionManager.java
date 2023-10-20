package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import edu.hw2.Task3.Random.Joker;

public class DefaultConnectionManager implements ConnectionManager {
    public static final double PROBABILITY_OF_EXCEPTION = 0.3;
    private static final Joker JOKER = new Joker(PROBABILITY_OF_EXCEPTION);

    /**
     * chooses the FaultyConnection or the StableConnection by joker.shouldItFail()
     *
     * @return the FaultyConnection or the StableConnection
     */
    @Override
    public Connection getConnection() {
        if (JOKER.shouldItFail()) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
