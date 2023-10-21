package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import edu.hw2.Task3.Random.Joker;

public class DefaultConnectionManager implements ConnectionManager {
    public static final double DEFAULT_PROBABILITY_OF_EXCEPTION = 0.3;
    private final Connection faultyConnection = new FaultyConnection();
    private final Connection stableConnection = new StableConnection();

    private final Joker joker;

    public DefaultConnectionManager(Joker joker) {
        this.joker = joker;
    }

    public DefaultConnectionManager() {
        this.joker = new Joker(DEFAULT_PROBABILITY_OF_EXCEPTION);
        ;
    }

    /**
     * chooses the FaultyConnection or the StableConnection by joker.shouldItFail()
     *
     * @return the FaultyConnection or the StableConnection
     */
    @Override
    public Connection getConnection() {
        if (joker.shouldItFail()) {
            return faultyConnection;
        } else {
            return stableConnection;
        }
    }
}
