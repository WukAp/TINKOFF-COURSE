package edu.hw2.Task3.ConnectionHendlers;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.Connections.Connection;

public class RetryConnectionHandler {
    private final int maxAttempts;

    /**
     * Hided Utility Class constructor
     */
    public RetryConnectionHandler(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    /**
     * tries execute() maxAttempts times
     *
     * @param task the task to try the retried executions
     */
    public void retryConnectionWithMaxRetries(TaskConnection task) {
        for (int i = 0; i <= maxAttempts; i++) {
            try (Connection connection = task.getConnection()) {
                task.execute();
                break;
            } catch (ConnectionException e) {
                if (i == maxAttempts) {
                    throw new ConnectionException("exceeded the maximum number of unsuccessful attempts", e.getCause());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Task to try the retried executions
     */
    public interface TaskConnection {
        void execute();

        Connection getConnection();

    }

}
