package edu.hw8.Task2;

import java.util.ArrayList;
import java.util.List;

public class FixedThreadPool implements ThreadPool {

    private List<Thread> threads;
    private int currentThreadsAmount;
    private final int maxThreadAmount;
    private Thread managerThread;

    public static FixedThreadPool create(int maxThreadsAmount) {
        FixedThreadPool fixedThreadPool = new FixedThreadPool(maxThreadsAmount);

        fixedThreadPool.threads = new ArrayList<>(maxThreadsAmount);

        return fixedThreadPool;
    }

    @Override
    public void start() {
        threads.forEach(Thread::start);
    }

    @Override
    public void execute(Runnable runnable) {
        if (++currentThreadsAmount < maxThreadAmount) {
            threads.add(new Thread(runnable));
        } else {
            throw new IllegalStateException("Too many threads");
        }

    }

    @Override
    public void close() throws Exception {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    private FixedThreadPool(int maxThreadsAmount) {

        maxThreadAmount = maxThreadsAmount;
    }
}
