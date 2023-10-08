package edu.hw1;

public class Task7 {
    /**
     * counts the amount of digits in a binary way
     *
     * @param inputNumber the input number
     * @return the amount of digits
     */
    private int countDigitsInBinary(int inputNumber) {
        int number = inputNumber;
        int result = 0;
        while (number != 0) {
            result++;
            number >>= 1;
        }
        return result;
    }

    /**
     * returns a cyclic shift of a number to the left
     *
     * @param n     the number that is being shifted
     * @param shift the shift size
     * @return the shifted number
     */
    public int rotateLeft(int n, int shift) {
        if (shift < 0) {
            return rotateRight(n, Math.abs(shift));
        }
        int size = countDigitsInBinary(n);
        return ((n << shift) | (n >> (size - shift))) & ((0b1 << size) - 1);
    }

    /**
     * returns a cyclic shift of a number to the right
     *
     * @param n     the number that is being shifted
     * @param shift the shift size
     * @return the shifted number
     */
    public int rotateRight(int n, int shift) {
        if (shift < 0) {
            return rotateLeft(n, Math.abs(shift));
        }
        int size = countDigitsInBinary(n);
        return ((n >> shift) | (n << (size - shift))) & ((0b1 << size) - 1);
    }
}
