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
    private final Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();

    private FixedThreadPool(int maxThreadsAmount) {
        threads = new ArrayList<>();
        this.isStarted = false;
        this.maxThreadsAmount = maxThreadsAmount;
    }

    /**
     * creates a FixedThreadPool with the maxThreadsAmount threads
     *
     * @param maxThreadsAmount the amount of real that will be created
     * @return the new FixedThreadPool with maxThreadsAmount threads
     */
    public static FixedThreadPool create(int maxThreadsAmount) {
        return new FixedThreadPool(maxThreadsAmount);
    }

    /**
     * allows the process of taking tasks by execute()
     */
    @Override
    public void start() {

        threads = Stream.generate(() -> new Thread(new ThreadPoolTask())).limit(maxThreadsAmount)
            .peek(Thread::start).toList();
        isStarted = true;
    }

    /**
     * adds the task in the taskQueue
     *
     * @param runnable the task
     */
    @Override
    public void execute(@NotNull Runnable runnable) {
        if (!isStarted) {
            throw new IllegalStateException("Pool is not started. Can't add new task!");
        }
        taskQueue.offer(runnable);
    }

    /**
     * prohibit the process of taking tasks by execute()
     * submitted tasks in the taskQueue will be running
     * this method does not wait for submitted tasks
     */
    @Override
    public void close() {
        isStarted = false;
    }

    /**
     * Blocks until all tasks have started
     */
    public void joinStartAll() throws InterruptedException {

        while (isStarted && !taskQueue.isEmpty()) {

        }
    }

    private class ThreadPoolTask implements Runnable {
        @Override
        public void run() {
            while (!taskQueue.isEmpty() || isStarted) {
                var task = taskQueue.poll();
                if (task != null) {
                    task.run();
                }

            }
        }
    }
}
