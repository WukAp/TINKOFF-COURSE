package edu.hw8.Task2;

import org.junit.jupiter.api.Test;

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

    @Test
    void calculateFibonacci() throws InterruptedException {
        FixedThreadPool fixedThreadPool = FixedThreadPool.create(10);
        fixedThreadPool.start();
        fixedThreadPool.execute(() -> assertEquals(5, getFibonacci(6)));
        fixedThreadPool.execute(() -> assertEquals(55, getFibonacci(11)));
        fixedThreadPool.execute(() -> assertEquals(610, getFibonacci(16)));
        fixedThreadPool.execute(() -> assertEquals(1597, getFibonacci(18)));
        fixedThreadPool.execute(() -> assertEquals(317811, getFibonacci(29)));
        fixedThreadPool.execute(() -> assertNotEquals(0, getFibonacci(29)));
        fixedThreadPool.execute(() -> assertNotEquals(0, getFibonacci(5)));
        fixedThreadPool.execute(() -> assertNotEquals(0, getFibonacci(8)));
        fixedThreadPool.joinStartAll();
        Thread.sleep(1000);
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
