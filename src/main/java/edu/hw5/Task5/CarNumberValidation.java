package edu.hw5.Task5;

public class CarNumberValidation {
    private static final String CAR_NUMBER_LETTERS = "[АВЕКМНОРСТУХ]";

    public boolean isCarNumberValid(String carNumber) {
        return carNumber.matches(CAR_NUMBER_LETTERS + "\\d{3}" + CAR_NUMBER_LETTERS + "{2}\\d{2,3}");
    }
}
