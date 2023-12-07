package edu.hw7.Task3.personDatabase;

import edu.hw7.Task3.Person;
import java.util.ArrayList;
import java.util.List;

public class SyncPersonDatabase implements PersonDatabase {
    private final List<Person> persons = new ArrayList<>();

    @Override
    public synchronized void add(Person person) {
        persons.add(person);
    }

    @Override
    public synchronized void delete(int id) {
        for (Person person : persons) {
            if (person.id() == id) {
                persons.remove(person);
                return;
            }
        }

    }

    @Override
    public synchronized List<Person> findByName(String name) {
        return persons.stream().filter(person -> person.name().equals(name)).toList();
    }

    @Override
    public synchronized List<Person> findByAddress(String address) {
        return persons.stream().filter(person -> person.address().equals(address)).toList();
    }

    @Override
    public synchronized List<Person> findByPhone(String phone) {
        return persons.stream().filter(person -> person.phoneNumber().equals(phone)).toList();
    }
}
