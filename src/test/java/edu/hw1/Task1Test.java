package edu.hw1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {
    private final Task1 testTask1 = new Task1();

    @Test
    void minutesToSecondsWithCorrectParams() {
        String testString1 = "0:0";
        Assertions.assertEquals(0, testTask1.minutesToSeconds(testString1));

        String testString2 = "0:50";
        Assertions.assertEquals(50, testTask1.minutesToSeconds(testString2));

        String testString3 = "1:00";
        Assertions.assertEquals(60, testTask1.minutesToSeconds(testString3));

        String testString4 = "1:10";
        Assertions.assertEquals(70, testTask1.minutesToSeconds(testString4));

        String testString5 = "1000:10";
        Assertions.assertEquals(60010, testTask1.minutesToSeconds(testString5));
    }

    @Test
    void minutesToSecondsWithIncorrectParams() {

        String testString1 = "";
        Assertions.assertEquals(-1, testTask1.minutesToSeconds(testString1));

        String testString2 = "a";
        Assertions.assertEquals(-1, testTask1.minutesToSeconds(testString2));

        String testString3 = "1:60";
        Assertions.assertEquals(-1, testTask1.minutesToSeconds(testString3));

        String testString4 = ":10";
        Assertions.assertEquals(-1, testTask1.minutesToSeconds(testString4));

        String testString5 = "0";
        Assertions.assertEquals(-1, testTask1.minutesToSeconds(testString5));
    }
}
