package edu.project3.models;

import java.util.Arrays;
import java.util.List;

public enum RequestMethod {
    GET,
    POST,
    PUT,
    DELETE,
    UPDATE,
    HEAD,
    OPTIONS,
    PATCH;

    public static List<String> getNamesList() {
        return Arrays.stream(RequestMethod.values()).map(Enum::name).toList();
    }

}
