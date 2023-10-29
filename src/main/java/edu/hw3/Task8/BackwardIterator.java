package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> collection;
    private int currentLocate;

    public BackwardIterator(List<T> collection) {
        this.collection = collection;
        this.currentLocate = collection.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentLocate >= 0;
    }

    @Override
    public T next() {
        if (currentLocate < 0) {
            throw new NoSuchElementException();
        }
        return collection.get(currentLocate--);
    }
}
