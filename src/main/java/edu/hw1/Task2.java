package edu.hw1;

public class Task2 {
    public static final int BASE = 10;

    /**
     * returns the amount of digits in BASE-based form of a number
     *
     * @param inputNum the input number
     * @return the amount of digits
     */
    public int countDigits(long inputNum) {
        long num = Math.abs(inputNum);
        int resultCounter = 0;
        do {
            resultCounter++;
            num /= BASE;
        } while (num > 0);
        return resultCounter;
    }
}
