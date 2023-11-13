package edu.hw5.Task6;

public class SubsequenceUtils {
    /**
     * searches for a subsequence in a string
     *
     * @param needle the subsequence to be found. Can't have a special characters of regular expressions
     * @param stack  the string where needle will be searched
     * @return true if needle is in the stack
     */
    public boolean isSubstring(String[] needle, String stack) {
        validate(needle, stack);
        String needleRegExp = String.join(".*", needle);
        return stack.matches(".*" + (needleRegExp) + ".*");
    }

    private void validate(String[] needle, String stack) {
        if (needle == null || needle.length == 0) {
            throw new IllegalArgumentException("needle shouldn't be empty");
        }
        if (stack == null || stack.isEmpty()) {
            throw new IllegalArgumentException("stack shouldn't be empty");
        }
    }
}
