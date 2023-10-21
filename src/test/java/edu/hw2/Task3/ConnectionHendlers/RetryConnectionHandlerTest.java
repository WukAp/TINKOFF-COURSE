package edu.hw2.Task3.ConnectionHendlers;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.Connections.Connection;
import edu.hw2.Task3.Connections.FaultyConnection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RetryConnectionHandlerTest {

    @Test
    void retryConnectionWithMaxRetries() {
        RetryConnectionHandler handler = new RetryConnectionHandler(1);
        var task = new RetryConnectionHandler.TaskConnection() {
            @Override
            public void execute() {
                throw new ConnectionException("Test exception", new Throwable());
            }

            @Override
            public Connection getConnection() {
                return new FaultyConnection();
            }
        };
        Assertions.assertThrows(ConnectionException.class, () -> handler.retryConnectionWithMaxRetries(task));
    }
}
