package edu.hw3.Task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static edu.hw3.Task5.Contacts.SortType.DESC;
import static edu.hw3.Task5.Contacts.SortType.ASC;
import static edu.hw3.Task5.Contacts.Person;

class ContactsTest {

    @Test
    void parseContacts() {
        Contacts contacts = new Contacts();

        Assertions.assertArrayEquals(
            new Person[] {new Person("Thomas", "Aquinas"),
                new Person("Rene", "Descartes"),
                new Person("David", "Hume"),
                new Person("John", "Locke")},
            contacts.parseContacts(
               List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"), ASC).toArray()
        );

        Assertions.assertArrayEquals(
            new Person[] {new Person("Carl", "Gauss"),
                new Person("Leonhard", "Euler"),
                new Person("Paul", "Erdos")},
            contacts.parseContacts(List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss"), DESC).toArray()
        );
        Assertions.assertArrayEquals(
            new Person[] {new Person("Leonhard", "Euler"),
                new Person("Paul", "Erdos"),
                new Person("Carl", null)},
            contacts.parseContacts(List.of("Paul Erdos", "Leonhard Euler", "Carl"), DESC).toArray()
        );

        Assertions.assertArrayEquals(new String[] {}, contacts.parseContacts(List.of(), DESC).toArray());
        Assertions.assertArrayEquals(new String[] {}, contacts.parseContacts(null, DESC).toArray());
    }

    @Test
    void parseContactsExceptions() {

        Contacts contacts = new Contacts();
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> contacts.parseContacts(Arrays.asList(null, "Leonhard Euler", "Carl Gauss"), DESC)
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> contacts.parseContacts(
                List.of("Leonhard Euler", "Alexander Stepanovich Popov", "Carl Gauss"),
                DESC
            )
        );
    }
}
