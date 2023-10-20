package edu.hw2.Task3;

import edu.hw2.Task3.Connections.Connection;

public class RetryConnectionHandler {
    /**
     * Hided Utility Class constructor
     */
    private RetryConnectionHandler() {
    }

    /**
     * tries execute() maxAttempts times
     *
     * @param task        the task to try the retried executions
     * @param maxAttempts the number of max retries
     */
    public static void retryConnectionWithMaxRetries(TaskConnection task, int maxAttempts) {
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
