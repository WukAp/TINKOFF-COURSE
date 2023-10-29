package edu.hw3.Task8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

class BackwardIteratorTest {

    @Test
    void hasNext() {
        Iterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));
        Assertions.assertTrue(iterator.hasNext());

        Iterator<Integer> emptyIterator = new BackwardIterator<>(List.of());
        Assertions.assertFalse(emptyIterator.hasNext());
    }

    @Test
    void next() {
        Iterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));
        Assertions.assertEquals(3, iterator.next());
        Assertions.assertEquals(2, iterator.next());
        Assertions.assertEquals(1, iterator.next());
    }

    @Test
    void nextException() {
        Iterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));
        Assertions.assertDoesNotThrow(iterator::next);
        Assertions.assertDoesNotThrow(iterator::next);
        Assertions.assertDoesNotThrow(iterator::next);
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void nextWithHasNext() {
        Iterator<Integer> iterator = new BackwardIterator<>(List.of(1, 2, 3));

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(3, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(2, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(1, iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }
}
