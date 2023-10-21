package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;

public class FaultyConnectionManager implements ConnectionManager {
    private final FaultyConnection faultyConnection = new FaultyConnection();

    @Override
    public Connection getConnection() {
        return faultyConnection;
    }
}
