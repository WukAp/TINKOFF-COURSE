package edu.hw5.Task6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SubsequenceUtilsTest {
    private final SubsequenceUtils substringUtils = new SubsequenceUtils();

    @Test
    void isSubsequence() {
        Assertions.assertTrue(substringUtils.isSubstring(new String[] {"a", "b", "c"}, "achfdbaabgabcaabg"));
        Assertions.assertTrue(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "boba"));
        Assertions.assertTrue(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "bob"));
        Assertions.assertTrue(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "abob"));
        Assertions.assertTrue(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "aboba"));
        Assertions.assertFalse(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "bbo"));
        Assertions.assertFalse(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "aaaa"));
        Assertions.assertFalse(substringUtils.isSubstring(new String[] {"b", "o", "b", "a"}, "bob"));
    }

    @Test
    void exceptions() {
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> substringUtils.isSubstring(new String[] {}, "aboba")
        );
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> substringUtils.isSubstring(new String[] {"sa"}, "")
        );
        Assertions.assertThrows(IllegalArgumentException.class, () -> substringUtils.isSubstring(null, "aboba"));
        Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> substringUtils.isSubstring(new String[] {"sa"}, null)
        );

    }
}
