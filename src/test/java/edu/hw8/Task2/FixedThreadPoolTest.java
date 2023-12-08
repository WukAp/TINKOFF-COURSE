package edu.hw8.Task2;

import net.jodah.concurrentunit.Waiter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.opentest4j.AssertionFailedError;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class FixedThreadPoolTest {

    @Test
    void create() {
        assertDoesNotThrow(() -> FixedThreadPool.create(10));
    }

    @Test
    void start() {
        assertDoesNotThrow(() -> FixedThreadPool.create(10).start());
    }

    @Test
    void execute() {
        assertDoesNotThrow(() -> FixedThreadPool.create(10).execute(() -> getFibonacci(50)));
    }

    @Test
    void close() {
        assertDoesNotThrow(() -> FixedThreadPool.create(10).close());
        assertDoesNotThrow(() -> {
            FixedThreadPool fixedThreadPool = FixedThreadPool.create(10);
            fixedThreadPool.start();
            fixedThreadPool.execute(() -> getFibonacci(6));
            fixedThreadPool.execute(() -> getFibonacci(11));
            fixedThreadPool.execute(() -> getFibonacci(16));
            fixedThreadPool.execute(() -> getFibonacci(18));
            fixedThreadPool.execute(() -> getFibonacci(29));
            fixedThreadPool.close();
        });
        assertDoesNotThrow(() -> {
            FixedThreadPool fixedThreadPool = FixedThreadPool.create(10);
            fixedThreadPool.start();
            fixedThreadPool.execute(() -> getFibonacci(6));
            fixedThreadPool.execute(() -> getFibonacci(11));
            fixedThreadPool.execute(() -> getFibonacci(16));
            fixedThreadPool.execute(() -> getFibonacci(18));
            fixedThreadPool.execute(() -> getFibonacci(29));
            fixedThreadPool.joinStartAll();
            fixedThreadPool.close();
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
        "6, 5",
        "11, 55",
        "16, 610",
        "18, 1597",
        "29, 317811",
    })
    void calculateFibonacci(int n, long answer) throws Throwable {

        final Waiter waiter = new Waiter();
        FixedThreadPool fixedThreadPool = FixedThreadPool.create(10);
        fixedThreadPool.start();
        fixedThreadPool.execute(() -> {
            waiter.assertTrue(answer == getFibonacci(n));
            waiter.resume();
        });
        waiter.await(1, TimeUnit.SECONDS);
        fixedThreadPool.close();
    }

    @Test
    void manyThreadsException() {
        FixedThreadPool fixedThreadPool = FixedThreadPool.create(10);
        fixedThreadPool.start();
        assertDoesNotThrow(() -> {
            for (int i = 0; i < 30; i++) {
                fixedThreadPool.execute(() -> {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {

                    }
                });
            }
            fixedThreadPool.joinStartAll();
        });

        fixedThreadPool.close();
    }

    private long getFibonacci(int n) {
        System.out.println(n);
        switch (n) {
            case 1:
                return 0;
            case 2:
                return 1;
            default: {
                long n1 = 0;
                long n2 = 1;
                long n3 = n1 + n2;
                for (int i = 3; i < n; ++i) {
                    n1 = n2;
                    n2 = n3;
                    n3 = n1 + n2;
                }
                return n3;
            }

        }

    }
}
