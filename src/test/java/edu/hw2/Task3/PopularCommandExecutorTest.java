package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManagers.DefaultConnectionManager;
import edu.hw2.Task3.Random.Joker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PopularCommandExecutorTest {

    @Test void tryExecuteDefaultConnectionManageException() {
        var commandExecutorSuccess =
            new PopularCommandExecutor(new DefaultConnectionManager(new Joker(0)), 100);

        Assertions.assertDoesNotThrow(() -> {
            commandExecutorSuccess.tryExecute("some command");
        });
    }

}
