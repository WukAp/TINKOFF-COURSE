package edu.hw7.Task3.personDatabase;

import edu.hw7.Task3.Person;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class SyncPersonDatabaseTest {
    SecureRandom random = new SecureRandom();

    @Test
    void add() {
        SyncPersonDatabase syncPersonDatabase = new SyncPersonDatabase();
        assertDoesNotThrow(
            () -> Stream.generate(() -> new Thread(() -> syncPersonDatabase
                    .add(new Person(random.nextInt(), "Sasha", "Secret address", "8800"))))
                .limit(10)
                .peek(Thread::start).toList());

    }

    @Test
    void delete() {
        SyncPersonDatabase syncPersonDatabase = new SyncPersonDatabase();
        for (int i = 0; i < 10; i++) {
            syncPersonDatabase.add(new Person(i, "Sasha", "Secret address", "8800"));
        }

        AtomicInteger counter = new AtomicInteger(0);

        assertDoesNotThrow(
            () -> {
                var threads = Stream.generate(() -> new Thread(() -> syncPersonDatabase
                        .delete(counter.getAndIncrement())))
                    .limit(10)
                    .peek(Thread::start).toList();
                for (Thread thread : threads) {
                    thread.join();
                }
            });
        assertTrue(syncPersonDatabase.findByName("Sasha").isEmpty());
    }

    @Test
    void findBy() {
        SyncPersonDatabase syncPersonDatabase = new SyncPersonDatabase();
        for (int i = 0; i < 10; i++) {
            syncPersonDatabase.add(new Person(i, "Sasha" + i, "Secret address" + i, "8800" + i));
        }
        AtomicInteger counter = new AtomicInteger(0);

        Stream.generate(() -> new Thread(() ->
            {
                assertFalse(syncPersonDatabase.findByName("Sasha" + counter.get()).isEmpty());
                assertFalse(syncPersonDatabase.findByPhone("8800" + counter.get()).isEmpty());
                assertFalse(syncPersonDatabase.findByAddress("Secret address" + counter.get()).isEmpty());
            }
            ))
            .limit(10)
            .peek(Thread::start).toList();
    }

}
