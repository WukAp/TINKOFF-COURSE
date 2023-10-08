package edu.hw1;

public class Task1 {
    public static final int MAX_SECONDS = 60;

    /**
     * checks that the string array contains only numbers
     *
     * @param stringArray the array that is being checked
     * @return true if array contains only numbers and false if not
     */
    private boolean isArrayOfNumbers(String[] stringArray) {
        for (String str : stringArray) {
            if (!str.matches("\\d+")) {
                return false;
            }
        }
        return true;
    }

    /**
     * converts time from mm:ss format to seconds
     *
     * @param timeInMMSSFormat the time in mm:ss format
     * @return amount of seconds
     */
    public int minutesToSeconds(String timeInMMSSFormat) {
        String[] time = timeInMMSSFormat.split(":");
        if (time.length != 2 || !isArrayOfNumbers(time) || Integer.parseInt(time[1]) >= MAX_SECONDS) {
            return -1;
        } else {
            return Integer.parseInt(time[1]) + Integer.parseInt(time[0]) * MAX_SECONDS;
        }
    }
}
