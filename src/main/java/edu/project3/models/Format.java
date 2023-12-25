package edu.project3.models;

public enum Format {
    ADOC, MARKDOWN;

    public static Format getFormat(String name) {
        return Format.valueOf(name.toUpperCase());
    }
}
