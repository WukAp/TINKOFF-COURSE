package edu.hw5.Task3;

import edu.hw5.Task3.Parsers.DateParser;
import edu.hw5.Task3.Parsers.EuroFormatParser;
import edu.hw5.Task3.Parsers.InternationalFormatParser;
import edu.hw5.Task3.Parsers.RelativeDaysParser;
import edu.hw5.Task3.Parsers.RelativeWordsParser;
import edu.hw5.Task3.Parsers.ShortEuroFormatParser;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UniversalParser {
    private final List<DateParser> parsers = List.of(new EuroFormatParser(), new InternationalFormatParser(),
        new RelativeDaysParser(), new RelativeWordsParser(), new ShortEuroFormatParser()
    );

    /**
     * parses string to local date
     *
     * @param string the string to be parsed
     * @return the parsed local date by known parsers
     */
    Optional<LocalDate> parseDate(String string) {
        for (DateParser parser : parsers) {
            if (parser.isMatch(string)) {
                return Optional.ofNullable(parser.parse(string));
            }
        }
        return Optional.empty();
    }
}
