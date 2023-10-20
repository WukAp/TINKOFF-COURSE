package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultConnectionManagerTest {

    @Test void getConnectionCheckingClasses() {
        for (int i = 0; i < 1000; i++) {
            Connection connection = new DefaultConnectionManager().getConnection();
            boolean isStable = connection.getClass() == StableConnection.class;
            boolean isFaulty = connection.getClass() == FaultyConnection.class;
            Assertions.assertTrue(isStable || isFaulty);

        }
    }
}
