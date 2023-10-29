package edu.hw3.Task1;

public class Atbash {

    /**
     * decipher the string with Atbash cipher
     *
     * @param inputString the string to decipher
     * @return the deciphered string
     */
    public String decipher(String inputString) {
        ASCIIRange upperCaseLetter = new ASCIIRange.UpperCaseLetter();
        ASCIIRange lowerCaseLetter = new ASCIIRange.LowerCaseLetter();
        StringBuilder outputStringBuilder = new StringBuilder();
        inputString.chars().mapToObj(c -> (char) c).map(character -> {
            if (lowerCaseLetter.isInRange(character)) {
                return decipherLetter(character, lowerCaseLetter);
            }

            if (upperCaseLetter.isInRange(character)) {
                return decipherLetter(character, upperCaseLetter);
            }
            return character;
        }).forEach(outputStringBuilder::append);
        return outputStringBuilder.toString();
    }

    private char decipherLetter(char letter, ASCIIRange asciiRange) {
        return (char) (asciiRange.getUpperBound() - (letter - asciiRange.getLowerBound()));
    }
}
