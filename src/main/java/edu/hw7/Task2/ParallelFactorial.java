package edu.hw7.Task2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.LongStream;

public class ParallelFactorial {

    public long getFactorial(int n) {
        AtomicInteger counter = new AtomicInteger();
        return LongStream.rangeClosed(1, n).parallel().reduce(1, (l, m) -> l * m);
    }
}
