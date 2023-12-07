package edu.hw7.Task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.*;

class MonteCarloMethodTest {
    MonteCarloMethod monteCarloMethod = new MonteCarloMethod();

    private final static Logger LOGGER = LogManager.getLogger();

    @Test
    void countPIUsingOneThread() {
        double eps = 0.01;
        assertTrue(Math.abs(monteCarloMethod.countPiUsingOneThread(1_000_000) - Math.PI) < eps);
        assertTrue(Math.abs(monteCarloMethod.countPiUsingOneThread(10_000_000) - Math.PI) < eps);
        assertTrue(Math.abs(monteCarloMethod.countPiUsingOneThread(1_000_000_000) - Math.PI) < eps);
    }

    @Test
    void countPiUsingMultiThread() throws ExecutionException, InterruptedException {

        double eps = 0.01;
        assertTrue(Math.abs(monteCarloMethod.countPiUsingMultiThread(1_000_000) - Math.PI) < eps);
        assertTrue(Math.abs(monteCarloMethod.countPiUsingMultiThread(10_000_000) - Math.PI) < eps);
        assertTrue(Math.abs(monteCarloMethod.countPiUsingMultiThread(1_000_000_000) - Math.PI) < eps);
    }

    @Test
    void getInfo() throws ExecutionException, InterruptedException {

        printComparison(100_000_000);
        printComparison(100_000_000);
        printComparison(1_000_000_000);
    }

    private void printComparison(int experience) throws ExecutionException, InterruptedException {
        long start = System.nanoTime();
        double pi = monteCarloMethod.countPiUsingOneThread(experience);
        long end = System.nanoTime();

        LOGGER.info("One thread\nexperience: " + experience + "\ntime: " + (end - start) + "mls" + "\ndelta: " +
            Math.abs(pi - Math.PI));

        start = System.nanoTime();
        pi = monteCarloMethod.countPiUsingMultiThread(experience);
        end = System.nanoTime();
        LOGGER.info("Multi threads\nexperience: " + experience + "\ntime: " + (end - start) + "mls" + "\ndelta: " +
            Math.abs(pi - Math.PI));

    }
}
