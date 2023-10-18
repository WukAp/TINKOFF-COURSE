package edu.hw2.Task3.Connections;

import edu.hw2.Task3.ConnectionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StableConnectionTest {

    @Test void execute() {
        final int experience = 10000;
        int attempt = 0;
        int successfulAttempt = 0;
        int failedAttempt = 0;
        for (int i = 0; i < experience; i++) {

            try (Connection connection = new StableConnection()) {
                attempt++;
                connection.execute("some command");
                successfulAttempt++;
            } catch (ConnectionException e) {
                failedAttempt++;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Assertions.assertTrue(successfulAttempt > 0);
        assertEquals(0, failedAttempt);
        assertEquals(experience, successfulAttempt);
        assertEquals(experience, attempt);
    }
}
