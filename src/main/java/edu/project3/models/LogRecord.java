package edu.project3.models;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.jetty.http.HttpStatus;

public record LogRecord(String remoteAddress, String remoteUser,
                        OffsetDateTime timeLocal, RequestMethod requestMethod, String requestUrl,
                        String requestProtocol,
                        HttpStatus.Code codeStatus,
                        int bodyBytesSent, String httpReferer, String httpUserAgent

) {
    @SuppressWarnings("MagicNumber")
    public static LogRecord parseLogRecord(String line) throws IOException {

        String getRequestMethods = String.join("|", RequestMethod.getNamesList());
        String address = "([.0-9]+|[:0-9abcdef]+)";

        Matcher matcher = Pattern.compile(address + " - (.*) \\[(.*)] \"(" + getRequestMethods
            + ") (.*) (.*)\" ([0-9]{3}) ([0-9]+) \"(.*)\" \"(.*)\".*").matcher(line);

        if (!matcher.find()) {
            throw new IOException("Can't parse the line " + line);
        }

        var time = OffsetDateTime.parse(matcher.group(3), DateTimeFormatter.ofPattern("dd/MMM/uuuu:HH:mm:ss Z"));
        return new LogRecord(
            matcher.group(1),
            matcher.group(2),
            time,
            RequestMethod.valueOf(matcher.group(4)),
            matcher.group(5),
            matcher.group(6),
            HttpStatus.getCode(Integer.parseInt(matcher.group(7))),
            Integer.parseInt(matcher.group(8)),
            matcher.group(9),
            matcher.group(10)
        );
    }
}


