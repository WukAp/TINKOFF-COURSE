package edu.hw2.Task3.Connections;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.Random.Joker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FaultyConnectionTest {

    @Test void execute() {
        Assertions.assertThrows(
            ConnectionException.class,
            () -> new FaultyConnection(new Joker(1)).execute("some command")
        );
        Assertions.assertDoesNotThrow(
            () -> new FaultyConnection(new Joker(0)).execute("some command")
        );
    }
}
