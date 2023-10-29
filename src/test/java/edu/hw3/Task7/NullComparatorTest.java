package edu.hw3.Task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NullComparatorTest {
    @Test
    void isNullAvailable() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator<String>());
        tree.put(null, "test");
        Assertions.assertTrue(tree.containsKey(null));
    }

    @Test
    void compare() {
        assertEquals(0, new NullComparator<Integer>().compare(null, null));
        Assertions.assertTrue(new NullComparator<Integer>().compare(null, Integer.MIN_VALUE) < 0);
        Assertions.assertTrue(new NullComparator<Integer>().compare(Integer.MIN_VALUE, null) > 0);
        assertEquals(0, new NullComparator<Integer>().compare(2, 2));
        Assertions.assertTrue(new NullComparator<Integer>().compare(2, 3) < 0);
        Assertions.assertTrue(new NullComparator<Integer>().compare(2, -1) > 0);
    }

}
