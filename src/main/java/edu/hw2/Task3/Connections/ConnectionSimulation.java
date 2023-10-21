package edu.hw2.Task3.Connections;

import edu.hw2.Task3.ConnectionException;
import edu.hw2.Task3.Terminals.Terminal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ConnectionSimulation implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Terminal terminal;

    /**
     * simulates the connection with the terminal
     * gets a ConnectionException() with ProbabilityOfException
     */
    public ConnectionSimulation() {
        terminal = command -> {
            if (shouldItFail()) {
                throw new ConnectionException("Connection have been interrupted", new Throwable());
            } else {
                LOGGER.info("Running: " + command);
            }
        };
    }

    /**
     * tries to execute the command
     */
    @Override
    public void execute(String command) {
        LOGGER.info("Connection have been started");
        terminal.runCommand(command);
    }

    @Override
    public void close() {
        LOGGER.info("Connection have been closed");
    }

    abstract boolean shouldItFail();
}
