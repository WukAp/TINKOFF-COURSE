package edu.hw7.Task3.personDatabase;

import edu.hw7.Task3.Person;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class ReadWriteLockPersonDatabaseTest {
    SecureRandom random = new SecureRandom();

    @Test
    void add() {
        ReadWriteLockPersonDatabase readWriteLockPersonDatabase = new ReadWriteLockPersonDatabase();
        assertDoesNotThrow(
            () -> Stream.generate(() -> new Thread(() -> readWriteLockPersonDatabase
                    .add(new Person(random.nextInt(), "Sasha", "Secret address", "8800"))))
                .limit(10)
                .peek(Thread::start).toList());

    }

    @Test
    void delete() {
        ReadWriteLockPersonDatabase readWriteLockPersonDatabase = new ReadWriteLockPersonDatabase();
        for (int i = 0; i < 10; i++) {
            readWriteLockPersonDatabase.add(new Person(i, "Sasha", "Secret address", "8800"));
        }

        AtomicInteger counter = new AtomicInteger(0);

        assertDoesNotThrow(
            () -> {
                var threads = Stream.generate(() -> new Thread(() -> readWriteLockPersonDatabase
                        .delete(counter.getAndIncrement())))
                    .limit(10)
                    .peek(Thread::start).toList();
                for (Thread thread : threads) {
                    thread.join();
                }
            });
        assertTrue(readWriteLockPersonDatabase.findByName("Sasha").isEmpty());
    }

    @Test
    void findBy() {
        ReadWriteLockPersonDatabase readWriteLockPersonDatabase = new ReadWriteLockPersonDatabase();
        for (int i = 0; i < 10; i++) {
            readWriteLockPersonDatabase.add(new Person(i, "Sasha" + i, "Secret address" + i, "8800" + i));
        }
        AtomicInteger counter = new AtomicInteger(0);

        Stream.generate(() -> new Thread(() ->
            {
                assertFalse(readWriteLockPersonDatabase.findByName("Sasha" + counter.get()).isEmpty());
                assertFalse(readWriteLockPersonDatabase.findByPhone("8800" + counter.get()).isEmpty());
                assertFalse(readWriteLockPersonDatabase.findByAddress("Secret address" + counter.get()).isEmpty());
            }
            ))
            .limit(10)
            .peek(Thread::start).toList();
    }

}
