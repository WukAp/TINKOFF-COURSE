package edu.hw3.Task7;

import java.util.Comparator;

public class NullComparator<T extends Comparable<T>> implements Comparator<T> {

    /**
     * extends the default comparator of comparable object with null case processing
     * null < any NotNullObject
     * null == null
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or
     *     a positive integer as o1 is less than, equal to, or greater than the o2.
     */
    @Override
    public int compare(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }
}
