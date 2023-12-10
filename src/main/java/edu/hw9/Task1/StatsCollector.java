package edu.hw9.Task1;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class StatsCollector {
    private final Map<String, StatInfo> statInfoMap = new ConcurrentHashMap<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void pushSync(String name, double... args) {
        lock.writeLock().lock();
        try {
            statInfoMap.put(name, new StatInfo(args));
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void pushAsync(String name, double... args) {
        CompletableFuture.supplyAsync(() -> new StatInfo(args)).thenAccept(statInfo -> {
            lock.writeLock().lock();
            try {
                statInfoMap.put(name, statInfo);
            } finally {
                lock.writeLock().unlock();
            }
        });
    }

    public ConcurrentHashMap<String, StatInfo> stat() {
        lock.readLock().lock();
        try {
            return new ConcurrentHashMap<>(statInfoMap);
        } finally {
            lock.readLock().unlock();
        }
    }
}
