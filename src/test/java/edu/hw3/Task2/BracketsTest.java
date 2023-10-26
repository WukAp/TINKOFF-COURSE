package edu.hw3.Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BracketsTest {

    @Test
    void clusterize() {
        Brackets brackets = new Brackets();

        Assertions.assertArrayEquals(new String[] {"()", "()", "()"}, brackets.clusterize("()()()").toArray());
        Assertions.assertArrayEquals(new String[] {"((()))"}, brackets.clusterize("((()))").toArray());
        Assertions.assertArrayEquals(
            new String[] {"((()))", "(())", "()", "()", "(()())"},
            brackets.clusterize("((()))(())()()(()())").toArray()
        );
        Assertions.assertArrayEquals(
            new String[] {"((())())", "(()(()()))"},
            brackets.clusterize("((())())(()(()()))").toArray()
        );
    }

    @Test
    void clusterizeExceptions() {
        Brackets brackets = new Brackets();

        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> brackets.clusterize("((")
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> brackets.clusterize("())")
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> brackets.clusterize("sasha")
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> brackets.clusterize("((((sasha))))")
        );
    }
}
