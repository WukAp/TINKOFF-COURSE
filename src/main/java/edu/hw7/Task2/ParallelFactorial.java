package edu.hw7.Task2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelFactorial {

    public int getFactorial(int n) {
        AtomicInteger counter = new AtomicInteger();
        return Stream.generate(counter::incrementAndGet).limit(n).parallel().reduce(1, (l, m) -> l * m);
    }
}
