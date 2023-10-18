package edu.hw2.Task3.Connections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    /**
     * execute the command
     */
    @Override public void execute(String command) {
        LOGGER.info("StableConnection have been started");
        LOGGER.info("Running: " + command);
    }

    @Override public void close() throws Exception {
        LOGGER.info("StableConnection have closed");
    }
}
