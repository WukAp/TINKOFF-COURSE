package edu.hw2.Task3.Connections;

import edu.hw2.Task3.ConnectionException;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Random random = new Random();

    /**
     * tries to execute the command
     * throws the Exceptions by 0.5 random
     */
    @Override public void execute(String command) {

        LOGGER.info("FaultyConnection have been started");
        if (random.nextBoolean()) {
            throw new ConnectionException("FaultyConnection have been interrupted", new Throwable());
        } else {
            LOGGER.info("Running: " + command);
        }
    }

    @Override public void close() throws Exception {
        LOGGER.info("FaultyConnection have been closed");
    }
}
