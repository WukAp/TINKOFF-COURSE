package edu.hw1;

public class Task4 {
    /**
     * swaps every two characters in a given string
     *
     * @param brokenString the input string
     * @return fixed string
     */
    public String fixString(String brokenString) {
        char[] fracturedString = brokenString.toCharArray();
        for (int i = 0; i < fracturedString.length - 1; i += 2) {
            char buf = fracturedString[i];
            fracturedString[i] = fracturedString[i + 1];
            fracturedString[i + 1] = buf;
        }
        return new String(fracturedString);
    }
}
