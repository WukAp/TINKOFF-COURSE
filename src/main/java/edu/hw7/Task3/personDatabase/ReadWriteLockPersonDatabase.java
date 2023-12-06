package edu.hw7.Task3.personDatabase;

import edu.hw7.Task3.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockPersonDatabase implements PersonDatabase {
    private final List<Person> persons = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

    @Override
    public void add(Person person) {
        lock.writeLock().lock();
        try {
            persons.add(person);
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public void delete(int id) {
        lock.writeLock().lock();
        try {
            for (Person person : persons) {
                if (person.id() == id) {
                    persons.remove(person);
                    return;
                }
            }
        } finally {
            lock.writeLock().unlock();
        }

    }

    @Override
    public List<Person> findByName(String name) {
        lock.readLock().lock();
        try {
            return persons.stream().filter(person -> person.name().equals(name)).toList();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByAddress(String address) {
        lock.readLock().lock();
        try {
            return persons.stream().filter(person -> person.address().equals(address)).toList();
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<Person> findByPhone(String phone) {
        lock.readLock().lock();
        try {
            return persons.stream().filter(person -> person.phoneNumber().equals(phone)).toList();
        } finally {
            lock.readLock().unlock();
        }
    }
}
