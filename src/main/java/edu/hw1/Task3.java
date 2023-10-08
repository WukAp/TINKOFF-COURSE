package edu.hw1;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Task3 {
    /**
     * returns true if a first array can be nested into a second array, false if not
     *
     * @param a1 the first array
     * @param a2 the second array
     * @return is arrays nestable
     */
    public boolean isNestable(int[] a1, int[] a2) {
        if (a1 == null || a2 == null || a1.length == 0 || a2.length == 0) {
            throw new IllegalArgumentException("input arrays shouldn't be empty");
        }
        int minA1 = a1[0];
        int maxA1 = a1[0];
        int minA2 = a2[0];
        int maxA2 = a2[0];

        for (int num : a1) {
            minA1 = min(num, minA1);
            maxA1 = max(num, maxA1);
        }
        for (int num : a2) {
            minA2 = min(num, minA2);
            maxA2 = max(num, maxA2);
        }
        return minA1 > minA2 && maxA1 < maxA2;
    }
}
