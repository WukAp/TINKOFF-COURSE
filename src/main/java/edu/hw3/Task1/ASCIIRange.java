package edu.hw3.Task1;

public sealed interface ASCIIRange {

    char getLowerBound();

    char getUpperBound();

    /**
     * checks is the character in the range of [getLowerBound(), getUpperBound()]
     *
     * @param character to checking
     * @return true if character is in range and false if not
     */
    default boolean isInRange(char character) {
        return (character >= getLowerBound()) && (character <= getUpperBound());
    }

    final class LowerCaseLetter implements ASCIIRange {
        @Override
        public char getLowerBound() {
            return 'a';
        }

        @Override
        public char getUpperBound() {
            return 'z';
        }
    }

    final class UpperCaseLetter implements ASCIIRange {
        @Override
        public char getLowerBound() {
            return 'A';
        }

        @Override
        public char getUpperBound() {
            return 'Z';
        }
    }

}
