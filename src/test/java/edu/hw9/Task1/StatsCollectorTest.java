package edu.hw9.Task1;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class StatsCollectorTest {

    @Test void push() {
        StatsCollector statsCollector = new StatsCollector();
        assertDoesNotThrow(() -> statsCollector.pushSync("testSync", 0.1, 1000, 201923));
        assertDoesNotThrow(() -> statsCollector.pushAsync("testAsync", 0.1, 1000, 201923));
    }

    @Test void stat() {
        StatsCollector statsCollector = new StatsCollector();
        statsCollector.pushSync("testSync1", -1000, 0, 1000, 1000);
        statsCollector.pushSync("testSync2", 0.1, 1000, 201923);
        statsCollector.pushSync("testSync3", 0.1, 1000, 201923);
        statsCollector.pushSync("testSync4", 0.1, 1000, 201923);
        var stat = statsCollector.stat();
        assertEquals(4, stat.size());
        assertTrue(stat.containsKey("testSync1") &&
            stat.containsKey("testSync2") &&
            stat.containsKey("testSync3") &&
            stat.containsKey("testSync4"));
        assertEquals(1000, stat.get("testSync1").getMax());
        assertEquals(-1000, stat.get("testSync1").getMin());
        assertEquals(250, stat.get("testSync1").getAverage());
        assertEquals(1000, stat.get("testSync1").getSum());
    }

    @Test void statUsingManyThreads() throws ExecutionException, InterruptedException {

        StatsCollector statsCollector = new StatsCollector();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Runnable addTask = () -> statsCollector.pushSync("test" + atomicInteger.getAndIncrement(), atomicInteger.get());

        List<CompletableFuture<Void>> futures =
            Stream.generate(() -> CompletableFuture.runAsync(addTask)).limit(10000).toList();
        for (var future : futures) {
            future.join();
        }
        assertEquals(10000, statsCollector.stat().size());

    }
}
