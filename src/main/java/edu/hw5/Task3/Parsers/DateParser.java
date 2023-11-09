package edu.hw5.Task3.Parsers;

import java.time.LocalDate;

public interface DateParser {

    /**
     * Tells is the string matches the getRegExp()
     *
     * @param string the string to be checked
     * @return true if this string matches the getRegExp() expression
     */
    default boolean isMatch(String string) {
        return string.matches(getRegExp());
    }

    /**
     * parses string to local date
     *
     * @param string the string to be parsed
     * @return the parsed local date
     */
    LocalDate parse(String string);

    String getRegExp();
}
