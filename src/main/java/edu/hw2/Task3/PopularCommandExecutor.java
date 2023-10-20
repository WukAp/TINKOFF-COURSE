package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionHendlers.RetryConnectionHandler;
import edu.hw2.Task3.ConnectionManagers.ConnectionManager;
import edu.hw2.Task3.Connections.Connection;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    /**
     * tries to execute the command by manager.getConnection() maxAttempts times
     * throws an exception if the commands fail to execute
     *
     * @param command the instructions to be executed on the system
     */
    public void tryExecute(String command) {
        RetryConnectionHandler retryConnectionHandler = new RetryConnectionHandler(maxAttempts);
        retryConnectionHandler.retryConnectionWithMaxRetries(new RetryConnectionHandler.TaskConnection() {
            @Override
            public void execute() {
                getConnection().execute(command);
            }

            @Override
            public Connection getConnection() {
                return manager.getConnection();
            }
        });
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }
}
