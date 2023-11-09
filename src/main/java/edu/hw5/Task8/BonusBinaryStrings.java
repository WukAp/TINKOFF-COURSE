package edu.hw5.Task8;

public class BonusBinaryStrings {
    public boolean isOddLength(String binaryString) {
        return binaryString.matches("(([01]){2})*([01])");
    }

    public boolean isOddAndStartsZeroOrEvenAndStartsOne(String binaryString) {
        return binaryString.matches("((0)|(1[01]))([01]{2})*");
    }

    public boolean isZerosAmountIsDivisibleByThree(String binaryString) {
        return binaryString.matches("((1*0){3})*1*");
    }

    public boolean isNot11or111(String binaryString) {
        return !binaryString.matches("111?");
    }

    public boolean isEveryOddSymbolIsOne(String binaryString) {
        return binaryString.matches("(1([10]1)*[10]?)?");
    }

    public boolean isTwoOrMoreZerosAndOneOrLessOne(String binaryString) {
        return binaryString.matches("^(00+1?0*)|(01?0+)|(1?00+)$");
    }

    public boolean isNotContains11(String binaryString) {
        return !binaryString.matches("[01]*11[01]*");
    }
}
