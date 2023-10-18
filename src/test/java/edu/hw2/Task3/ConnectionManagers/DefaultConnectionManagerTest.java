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

    @Test void getConnectionCheckingProbability() {
        final int experience = 10000;
        int faultyConnectionsCounter = 0;
        int stableConnectionsCounter = 0;
        for (int i = 0; i < experience; i++) {
            Connection connection = new DefaultConnectionManager().getConnection();

            boolean isStable = connection.getClass() == StableConnection.class;
            boolean isFaulty = connection.getClass() == FaultyConnection.class;
            if (isStable) {
                stableConnectionsCounter++;
            }
            if (isFaulty) {
                faultyConnectionsCounter++;
            }
        }
        Assertions.assertTrue(faultyConnectionsCounter > 0);
        Assertions.assertTrue(stableConnectionsCounter > 0);
        Assertions.assertTrue(Math.abs(faultyConnectionsCounter - experience / 2) < experience / 4);
        Assertions.assertTrue(Math.abs(stableConnectionsCounter - experience / 2) < experience / 4);
    }
}
