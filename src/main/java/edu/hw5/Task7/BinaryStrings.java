package edu.hw5.Task7;

public class BinaryStrings {

    public boolean isTheThirdCharacterIsZero(String binaryString) {
        validateBinaryString(binaryString);
        return binaryString.matches("[01]{2}0.*");
    }

    public boolean isFirstEqualsLast(String binaryString) {
        validateBinaryString(binaryString);
        return binaryString.matches("(0)|(1)|(^0.*0$)|(^1.*1$)");
    }

    public boolean isLengthBetweenOneAndThree(String binaryString) {
        validateBinaryString(binaryString);
        return binaryString.matches("[01]{1,3}");
    }

    private void validateBinaryString(String binaryString) {
        if (!binaryString.matches("[01]*")) {
            throw new IllegalArgumentException("Binary string should has only [01] characters");
        }
    }
}
