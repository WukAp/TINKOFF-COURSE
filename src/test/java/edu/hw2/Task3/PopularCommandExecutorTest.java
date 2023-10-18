package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManagers.DefaultConnectionManager;
import edu.hw2.Task3.ConnectionManagers.FaultyConnectionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PopularCommandExecutorTest {

    @Test void updatePackages() {
    }

    @Test void tryExecuteDefaultConnectionManageException() {
        final int experience = 10000;
        PopularCommandExecutor commandExecutor = new PopularCommandExecutor(new DefaultConnectionManager(), 1);
        Assertions.assertThrows(ConnectionException.class, () -> {
            for (int i = 0; i < experience; i++) {
                commandExecutor.tryExecute("some command");
            }
        });
    }

    @Test void tryExecuteFaultyConnectionManagerException() {
        final int experience = 10000;
        PopularCommandExecutor commandExecutor = new PopularCommandExecutor(new FaultyConnectionManager(), 1);
        Assertions.assertThrows(ConnectionException.class, () -> {
            for (int i = 0; i < experience; i++) {
                commandExecutor.tryExecute("some command");
            }
        });
    }
}
