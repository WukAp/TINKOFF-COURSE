package edu.hw7.Task1;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class MultiThreadedAdder {

    private final AtomicLong count = new AtomicLong(0);

    public void add(int n) throws InterruptedException {
        List<Thread> threads =
            Stream.generate(() -> new Thread(count::incrementAndGet)).limit(n).peek(Thread::start).toList();

        for (Thread thread : threads) {
            thread.join();
        }
    }

    public AtomicLong getCount() {
        return count;
    }

}
