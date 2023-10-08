package edu.hw1;

import java.util.Arrays;

public class Task6 {
    public static final char[] KAPREKAR_CONST = new char[] {'6', '1', '7', '4'};

    /**
     * returns next Kaprekar number
     *
     * @param number the previous number
     * @return the next Kaprekar number
     */
    private char[] getNextKaprekarNumber(char[] number) {
        Arrays.sort(number);
        String numberStr = new String(number);
        int num1 = Integer.parseInt(numberStr);
        int num2 = Integer.parseInt(new String(new StringBuilder(numberStr).reverse()));
        return String.valueOf(num2 - num1).toCharArray();
    }

    /**
     * finds the amount of steps to reach the KAPREKAR_CONST using recursion
     *
     * @param inputNumberChr the input number
     * @param counter        current recursion nesting level
     * @return the amount of steps
     */

    private int countKHelper(char[] inputNumberChr, int counter) {

        char[] numberChr = Arrays.copyOf(inputNumberChr, inputNumberChr.length);
        if (Arrays.equals(numberChr, KAPREKAR_CONST)) {
            return counter;
        }
        return countKHelper(getNextKaprekarNumber(numberChr), counter + 1);
    }

    /**
     * finds the amount of steps to reach the KAPREKAR_CONST
     *
     * @param number the input number
     * @return the amount of steps
     */
    public int countK(int number) {
        char[] numberChr = String.valueOf(number).toCharArray();
        return countKHelper(numberChr, 0);
    }
}
