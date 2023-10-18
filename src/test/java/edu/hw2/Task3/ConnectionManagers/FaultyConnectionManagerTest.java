package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FaultyConnectionManagerTest {

    @Test void getConnection() {
        for (int i = 0; i < 1000; i++) {
            Connection connection = new FaultyConnectionManager().getConnection();
            Assertions.assertSame(FaultyConnection.class, connection.getClass());
        }
    }

}
