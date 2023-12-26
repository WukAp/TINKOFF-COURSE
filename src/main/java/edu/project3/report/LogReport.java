package edu.project3.report;

import edu.project3.models.LogRecord;
import edu.project3.models.RequestMethod;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.eclipse.jetty.http.HttpStatus;

public class LogReport {

    private final List<LogRecord> logReports;

    public LogReport(List<LogRecord> logReports) {
        this.logReports = logReports;
    }

    public int getLogsAmount() {
        return logReports.size();
    }

    public Map<String, Integer> getPopularRequestsURL(int limit) {
        Map<String, Integer> countMap = getCountMap(logReports.stream().map(LogRecord::requestUrl).toList());
        return countMap.entrySet().stream()
            .sorted((entry1, entry2) -> -Integer.compare(entry1.getValue(), entry2.getValue())).limit(limit).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<HttpStatus.Code, Integer> getPopularCodes(int limit) {
        Map<HttpStatus.Code, Integer> countMap = getCountMap(logReports.stream().map(LogRecord::codeStatus).toList());
        return countMap.entrySet().stream()
            .sorted((entry1, entry2) -> -Integer.compare(entry1.getValue(), entry2.getValue())).limit(limit).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Integer> getActiveUsers(int limit) {
        Map<String, Integer> countMap = getCountMap(logReports.stream().map(LogRecord::remoteAddress).toList());
        return countMap.entrySet().stream()
            .sorted((entry1, entry2) -> -Integer.compare(entry1.getValue(), entry2.getValue())).limit(limit).collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<RequestMethod, Integer> getRequestMethodCounted() {
        return getCountMap(logReports.stream().map(LogRecord::requestMethod).toList());
    }

    public double getSizeInAverage() {
        return logReports.stream().mapToInt(LogRecord::bodyBytesSent).average().orElseThrow();
    }

    private <K> Map<K, Integer> getCountMap(List<K> list) {
        Map<K, Integer> countMap = new HashMap<>();
        for (var valueK : list) {
            if (countMap.containsKey(valueK)) {
                countMap.put(valueK, countMap.get(valueK) + 1);
            } else {
                countMap.put(valueK, 1);
            }
        }
        return countMap;
    }
}
