package edu.hw5.Task3.Parsers;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class RelativeWordsParser implements DateParser {
    private enum RelativeTimePointers {
        tomorrow((date) -> date.plusDays(1)),
        today((date) -> date),
        yesterday((date) -> date.minusDays(1));

        RelativeTimePointers(UnaryOperator<LocalDate> moveDate) {
            this.moveDate = moveDate;
        }

        public LocalDate getDate() {
            return moveDate.apply(LocalDate.now());
        }

        private final UnaryOperator<LocalDate> moveDate;

    }

    @Override
    public LocalDate parse(String string) {
        for (RelativeTimePointers value : RelativeTimePointers.values()) {
            if (string.equals(value.name())) {
                return value.getDate();
            }
        }
        throw new IllegalArgumentException("unknown time pointer word");
    }

    @Override
    public String getRegExp() {
        return "^"
            + String.join("|", Arrays.stream(RelativeTimePointers.values())
            .map(Enum::name)
            .toArray(String[]::new))
            + "$";
    }
}
