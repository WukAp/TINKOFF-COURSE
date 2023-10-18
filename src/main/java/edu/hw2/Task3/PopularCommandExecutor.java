package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManagers.ConnectionManager;
import edu.hw2.Task3.Connections.Connection;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    /**
     * tries to execute the command by manager.getConnection() maxAttempts times
     * throws an exception if the commands fail to execute
     *
     * @param command the instructions to be executed on the system
     */
    public void tryExecute(String command) {
        int currentAAttempt = 0;
        boolean isExecuted = false;
        while (!isExecuted && currentAAttempt < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                currentAAttempt++;
                connection.execute(command);
                isExecuted = true;
            } catch (ConnectionException e) {
                if (currentAAttempt == maxAttempts) {
                    throw new ConnectionException("exceeded the maximum number of unsuccessful attempts", e.getCause());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
