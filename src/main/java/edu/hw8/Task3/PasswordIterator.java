package edu.hw8.Task3;

import java.util.Iterator;
import java.util.List;

public class PasswordIterator implements Iterator<String> {
    private static final List<Character> PASSWORD_CHARACTERS = List.of(
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    );
    private final char[] password;
    private final int unknownLetters;
    private Iterator<Character>[] characterIterators;

    public PasswordIterator(int length) {
        this.unknownLetters = length;
        this.password = new char[length];
        this.characterIterators = new Iterator[length];
        for (int i = 0; i < length; i++) {
            characterIterators[i] = PASSWORD_CHARACTERS.iterator();
        }
    }

    public PasswordIterator(int length, char lastChar) {
        this.unknownLetters = length - 1;
        this.password = new char[length];
        this.password[length - 1] = lastChar;
        this.characterIterators = new Iterator[this.unknownLetters];
        for (int i = 0; i < this.unknownLetters; i++) {
            characterIterators[i] = PASSWORD_CHARACTERS.iterator();
        }
    }

    public static Iterator<Character> getCharacterIterator() {
        return PASSWORD_CHARACTERS.iterator();
    }

    @Override
    public boolean hasNext() {
        return characterIterators[0].hasNext();
    }

    @Override
    public String next() {
        for (int i = unknownLetters - 1; i >= 0; i--) {
            if (characterIterators[i].hasNext()) {
                password[i] = characterIterators[i].next();
                return String.valueOf(password).trim();
            } else {
                if (i > 0) {
                    characterIterators[i] = PASSWORD_CHARACTERS.iterator();
                }
            }
        }
        throw new IllegalStateException("has not next element");
    }
}
