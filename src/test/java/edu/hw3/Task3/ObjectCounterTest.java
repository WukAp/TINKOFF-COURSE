package edu.hw3.Task3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ObjectCounterTest {

    @Test
    void freqDict() {
        ObjectCounter wordCounter = new ObjectCounter();
        var mapFromExample1 = wordCounter.freqDict(List.of("a", "bb", "a", "bb"));
        var mapFromExample2 = wordCounter.freqDict(List.of("this", "and", "that", "and"));
        var mapFromExample3 = wordCounter.freqDict(List.of("код", "код", "код", "bug"));
        var mapFromExample4 = wordCounter.freqDict(List.of(1, 1, 2, 2));

        Assertions.assertEquals(2, mapFromExample1.size());
        Assertions.assertEquals(2, mapFromExample1.get("bb"));
        Assertions.assertEquals(2, mapFromExample1.get("a"));

        Assertions.assertEquals(3, mapFromExample2.size());
        Assertions.assertEquals(1, mapFromExample2.get("that"));
        Assertions.assertEquals(2, mapFromExample2.get("and"));
        Assertions.assertEquals(1, mapFromExample2.get("this"));

        Assertions.assertEquals(2, mapFromExample3.size());
        Assertions.assertEquals(3, mapFromExample3.get("код"));
        Assertions.assertEquals(1, mapFromExample3.get("bug"));

        Assertions.assertEquals(2, mapFromExample4.size());
        Assertions.assertEquals(2, mapFromExample4.get(1));
        Assertions.assertEquals(2, mapFromExample4.get(2));
    }
}
