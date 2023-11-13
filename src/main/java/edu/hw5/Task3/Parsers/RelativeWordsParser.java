package edu.hw5.Task3.Parsers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class RelativeWordsParser implements DateParser {
    private enum RelativeTimePointers {
        TOMORROW((date) -> date.plusDays(1)),
        TODAY((date) -> date),
        YESTERDAY((date) -> date.minusDays(1));

        RelativeTimePointers(UnaryOperator<LocalDate> moveDate) {
            this.moveDate = moveDate;
        }

        public LocalDate getDate() {
            return moveDate.apply(LocalDate.now());
        }

        public String getWord() {
            return this.name().toLowerCase();
        }

        private final UnaryOperator<LocalDate> moveDate;

    }

    @Override
    public LocalDate parse(String string) {
        for (RelativeTimePointers value : RelativeTimePointers.values()) {
            if (string.equals(value.getWord())) {
                return value.getDate();
            }
        }
        throw new IllegalArgumentException("unknown time pointer word");
    }

    @Override
    public String getRegExp() {
        return "^"
            + String.join("|", Arrays.stream(RelativeTimePointers.values())
            .map(RelativeTimePointers::getWord)
            .toArray(String[]::new))
            + "$";
    }
}
