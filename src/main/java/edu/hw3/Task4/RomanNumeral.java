package edu.hw3.Task4;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class RomanNumeral {
    private final Map<Integer, String> romanDigits = Arrays.stream(RomanDigits.values()).collect(Collectors.toMap(
        RomanDigits::getValue, Enum::name));

    /**
     * converts the number from arabic numeral system to roman numeral system
     *
     * @param inputArabicNumber the number to convert
     * @return the number in roman numeral system
     */
    public String convertToRoman(int inputArabicNumber) {
        if (inputArabicNumber <= 0) {
            throw new IllegalArgumentException("Can't convert negative number");
        }
        int arabicNumber = inputArabicNumber;
        StringBuilder outputStringBoulder = new StringBuilder();
        for (var romanDigit : romanDigits.entrySet().stream()
            .sorted((o1, o2) -> -Integer.compare(o1.getKey(), o2.getKey())).toList()) {
            while (arabicNumber >= romanDigit.getKey()) {
                outputStringBoulder.append(romanDigit.getValue());
                arabicNumber -= romanDigit.getKey();
            }
        }
        return outputStringBoulder.toString();
    }
}
