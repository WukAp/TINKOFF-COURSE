package edu.hw5.Task6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubsequenceUtilsTest {
    private final SubsequenceUtils substringUtils = new SubsequenceUtils();

    @Test
    void isSubsequence() {
        assertTrue(substringUtils.isSubstring(new String[] {"a", "b", "c"}, "achfdbaabgabcaabg"));
        assertTrue(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "boba"));
        assertTrue(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "bob"));
        assertTrue(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "abob"));
        assertTrue(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "aboba"));
        assertFalse(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "bbo"));
        assertFalse(substringUtils.isSubstring(new String[] {"b", "o", "b"}, "aaaa"));
        assertFalse(substringUtils.isSubstring(new String[] {"b", "o", "b", "a"}, "bob"));
    }

    @Test
    void exceptions() {
        assertThrows(
            IllegalArgumentException.class,
            () -> substringUtils.isSubstring(new String[] {}, "aboba")
        );
        assertThrows(
            IllegalArgumentException.class,
            () -> substringUtils.isSubstring(new String[] {"sa"}, "")
        );
        assertThrows(IllegalArgumentException.class, () -> substringUtils.isSubstring(null, "aboba"));
        assertThrows(
            IllegalArgumentException.class,
            () -> substringUtils.isSubstring(new String[] {"sa"}, null)
        );

    }
}
