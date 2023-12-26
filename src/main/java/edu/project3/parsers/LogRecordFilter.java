package edu.project3.parsers;

import edu.project3.models.LogRecord;
import java.time.LocalDate;

@FunctionalInterface
public interface LogRecordFilter {
    boolean isRequired(LogRecord logRecord);

    default LogRecordFilter add(LogRecordFilter logRecordFilter) {
        return (logRecord) -> this.isRequired(logRecord) && logRecordFilter.isRequired(logRecord);
    }

    record FilterWithFromDate(LocalDate fromDate) implements LogRecordFilter {
        @Override
        public boolean isRequired(LogRecord logRecord) {
            return logRecord.timeLocal().toLocalDate().isAfter(fromDate)
                || logRecord.timeLocal().toLocalDate().isEqual(fromDate);
        }
    }

    record FilterWithToDate(LocalDate toDate) implements LogRecordFilter {
        @Override
        public boolean isRequired(LogRecord logRecord) {
            return logRecord.timeLocal().toLocalDate().isBefore(toDate)
                || logRecord.timeLocal().toLocalDate().isEqual(toDate);
        }
    }

    record FilterWithFromToDate(LocalDate fromDate, LocalDate toDate) implements LogRecordFilter {
        @Override
        public boolean isRequired(LogRecord logRecord) {
            return new FilterWithToDate(toDate).add(new FilterWithFromDate(fromDate)).isRequired(logRecord);
        }
    }

    record EmptyConditionalFilter() implements LogRecordFilter {
        @Override
        public boolean isRequired(LogRecord logRecord) {
            return true;
        }
    }
}
