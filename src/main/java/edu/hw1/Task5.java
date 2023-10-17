package edu.hw1;

import static edu.hw1.Task2.BASE;

public class Task5 {

    /**
     * checks that a string is descendant palindrome
     *
     * @param number the checked number
     * @return true if descendant palindrome and false if not
     */
    public boolean isPalindromeDescendant(int number) {
        StringBuilder numberStr = new StringBuilder(String.valueOf(Math.abs(number)));
        do {
            if (isPalindrome(numberStr)) {
                return true;
            }
            numberStr = getChildOfNumber(numberStr);
        } while (numberStr != null && numberStr.length() > 1);
        return false;
    }

    /**
     * checks that a string is a palindrome
     *
     * @param numberStr the string that is being checked
     * @return true if palindrome and false if not
     */
    private boolean isPalindrome(StringBuilder numberStr) {
        return numberStr.compareTo(new StringBuilder(numberStr).reverse()) == 0;
    }

    /**
     * returns child number that is given by adding the number of each pair of adjacent digits
     *
     * @param numberStr the parent number
     * @return the child number
     */
    private StringBuilder getChildOfNumber(StringBuilder numberStr) {
        if (numberStr.length() % 2 == 1) {
            return null;
        }
        int number = Integer.parseInt(String.valueOf(numberStr));
        StringBuilder children = new StringBuilder();
        for (int i = 0; i < numberStr.length() / 2; i++) {
            children.append(number % BASE + number % (BASE * BASE) / BASE);
            number /= (BASE * BASE);
        }
        return children;
    }
}
