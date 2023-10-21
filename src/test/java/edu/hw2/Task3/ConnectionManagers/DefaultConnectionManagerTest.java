package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import edu.hw2.Task3.Random.Joker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DefaultConnectionManagerTest {

    @Test void getConnectionCheckingClasses() {
        Connection connectionFail = new DefaultConnectionManager(new Joker(1)).getConnection();
        Connection connectionSuccess = new DefaultConnectionManager(new Joker(0)).getConnection();
        Assertions.assertEquals(FaultyConnection.class, connectionFail.getClass());
        Assertions.assertEquals(StableConnection.class, connectionSuccess.getClass());
    }
}
