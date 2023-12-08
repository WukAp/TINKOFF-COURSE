package edu.hw9;

import java.util.Arrays;

public class StatInfo {
    private final double max;
    private final double min;
    private final double average;
    private final double sum;

    public StatInfo(double... args) {
        this.max = Arrays.stream(args).max().orElseThrow();
        this.min = Arrays.stream(args).min().orElseThrow();
        this.average = Arrays.stream(args).average().orElseThrow();
        this.sum = Arrays.stream(args).sum();
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }

    public double getSum() {
        return sum;
    }
}
