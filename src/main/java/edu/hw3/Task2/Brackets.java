package edu.hw3.Task2;

import java.util.Collection;
import java.util.LinkedList;

public class Brackets {
    private final char openBracket = '(';
    private final char closeBracket = ')';

    /**
     * gets irreducible inseparable math correct clusters of brackets
     *
     * @param inputBrackets the string with a stream of brackets
     * @return the Collection with correct clusters of brackets
     */
    public Collection<String> clusterize(String inputBrackets) {

        LinkedList<String> outputCollection = new LinkedList<>();

        int openBracketCounter = 0;
        int closeBracketCounter = 0;
        int firstCharUnsavedIndex = 0;
        for (int i = 0; i < inputBrackets.length(); i++) {
            var character = inputBrackets.charAt(i);
            switch (character) {
                case openBracket:
                    openBracketCounter++;
                    break;
                case closeBracket:
                    closeBracketCounter++;
                    break;
                default:
                    throw new IllegalArgumentException("input string should have only '(' and ')' characters");
            }

            if (openBracketCounter == closeBracketCounter) {
                outputCollection.add(inputBrackets.substring(firstCharUnsavedIndex, i + 1));
                firstCharUnsavedIndex = i + 1;
            } else if (openBracketCounter < closeBracketCounter) {
                throw new IllegalArgumentException("illegal brackets usage. ')' quantity exceeded");
            }
        }
        if (openBracketCounter > closeBracketCounter) {
            throw new IllegalArgumentException("illegal brackets usage. '(' quantity exceeded");
        }
        return outputCollection;
    }
}
