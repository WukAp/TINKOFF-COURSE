package edu.hw8.Task2;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
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
            fixedThreadPool.execute(() -> getFibonacci(6));
            fixedThreadPool.execute(() -> getFibonacci(11));
            fixedThreadPool.execute(() ->  getFibonacci(16));
            fixedThreadPool.execute(() ->  getFibonacci(18));
            fixedThreadPool.execute(() -> getFibonacci(29));
            fixedThreadPool.start();
            fixedThreadPool.close();
        });
    }

    @Test
    void calculateFibonacci() {
        FixedThreadPool fixedThreadPool = FixedThreadPool.create(10);
        fixedThreadPool.execute(() -> assertEquals(5, getFibonacci(6)));
        fixedThreadPool.execute(() -> assertEquals(55, getFibonacci(11)));
        fixedThreadPool.execute(() -> assertEquals(610, getFibonacci(16)));
        fixedThreadPool.execute(() -> assertEquals(1597, getFibonacci(18)));
        fixedThreadPool.execute(() -> assertEquals(317811, getFibonacci(29)));
        fixedThreadPool.start();
    }

    @Test
    void tooManyThreadsException() {
        FixedThreadPool fixedThreadPool = FixedThreadPool.create(10);
        assertThrows(IllegalStateException.class, () -> {
            for (int i = 0; i < 11; i++) {
                fixedThreadPool.execute(() -> {
                });
            }
        });
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
