package edu.hw3.Task5;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class Contacts {

    /**
     * parses the collection of string view of contacts to
     * list of person
     * sorts the list of contacts
     *
     * @param inputCollection the collection of string view of contacts
     * @param sortType        the type of available sorts
     * @return the sorted list of contacts
     */
    public List<Person> parseContacts(Collection<String> inputCollection, SortType sortType) {
        if (inputCollection == null || inputCollection.isEmpty()) {
            return List.of();
        }
        return switch (sortType) {

            case ASC -> parseContactsASC(inputCollection);
            case DESC -> parseContactsDECS(inputCollection);
        };

    }

    private List<Person> parseContactsASC(Collection<String> inputCollection) {
        return inputCollection.stream().map(this::parseContact).sorted().toList();
    }

    private List<Person> parseContactsDECS(Collection<String> inputCollection) {
        return inputCollection.stream().map(this::parseContact).sorted((o1, o2) -> -o1.compareTo(o2)).toList();
    }

    private Person parseContact(String contact) {
        String contactSplitter = " ";
        if (contact == null || contact.isBlank()) {
            throw new IllegalArgumentException("contacts should be not null");
        }
        String[] nameParts = contact.split(contactSplitter);
        return switch (nameParts.length) {
            case 1 -> new Person(nameParts[0], null);
            case 2 -> new Person(nameParts[0], nameParts[1]);
            default -> throw new IllegalArgumentException("contacts should have two parts");
        };
    }

    public enum SortType {
        ASC, DESC
    }

    public record Person(@NotNull String name, String surname) implements Comparable<Person> {

        @Override
        public int compareTo(@NotNull Contacts.Person o) {
            String memberOfO1 = (this.surname != null ? this.surname : this.name);
            String memberOfO2 = (o.surname != null ? o.surname : o.name);
            return memberOfO1.compareTo(memberOfO2);
        }
    }
}
