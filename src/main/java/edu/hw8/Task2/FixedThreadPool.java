package edu.hw8.Task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public class FixedThreadPool implements ThreadPool {
    private List<Thread> threads;
    private final int maxThreadsAmount;
    private volatile boolean isStarted;
    private final Queue<Runnable> workQueue = new ConcurrentLinkedQueue<>();

    private FixedThreadPool(int maxThreadsAmount) {
        threads = new ArrayList<>();
        this.isStarted = false;
        this.maxThreadsAmount = maxThreadsAmount;
    }

    public static FixedThreadPool create(int maxThreadsAmount) {
        return new FixedThreadPool(maxThreadsAmount);
    }

    @Override
    public void start() {
        threads = Stream.generate(() -> new Thread(new ThreadPoolTask())).limit(maxThreadsAmount)
            .peek(Thread::start).toList();
        isStarted = true;

    }

    @Override
    public void execute(@NotNull Runnable runnable) {
        workQueue.offer(runnable);
    }

    @Override
    public void close() {
        isStarted = false;
        workQueue.clear();
        for (Thread thread : threads) {
            thread.interrupt();
            if (!thread.isInterrupted()) {
                throw new IllegalStateException("Can't stop thread");
            }
        }
    }

    public void joinStartAll() throws InterruptedException {

        while (isStarted && !workQueue.isEmpty()){

        }
    }

    private class ThreadPoolTask implements Runnable {
        @Override
        public synchronized void run() {
            while (isStarted) {
                var task = workQueue.poll();
                if (task != null) {
                    task.run();
                }

            }
        }
    }
}
