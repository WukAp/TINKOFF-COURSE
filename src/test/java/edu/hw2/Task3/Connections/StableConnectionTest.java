package edu.hw2.Task3.Connections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StableConnectionTest {

    @Test void execute() {
        Assertions.assertDoesNotThrow(
            () -> new StableConnection().execute("some command")
        );
    }
}
