package edu.hw6.Task3;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.AccessMode;
import java.nio.file.Path;

public class MyFilters {
    public AbstractFilter hasAttribute(AccessMode... modes) {
        return (Path entry) -> {
            try {
                entry.getFileSystem().provider().checkAccess(entry, modes);
                return true;
            } catch (IOException e) {
                return false;
            }
        };
    }

    public AbstractFilter largerThan(int length) {
        return (Path entry) -> entry.toFile().length() > length;
    }

    public AbstractFilter globMatches(String regExp) {
        return (Path entry) -> entry.toString().contains("." + regExp);
    }

    public AbstractFilter regexContains(String regExp) {
        return (Path entry) -> entry.toString().contains(regExp);
    }

    public AbstractFilter magicNumber(char... magicNumbers) {

        return (Path entry) -> {
            var inputStream = new FileInputStream(entry.toFile());
            byte number = (byte) inputStream.read();
            inputStream.close();
            for (int i = 0; i < magicNumbers.length; i++) {
                if (magicNumbers[i] == number) {
                    return true;
                }
            }
            return false;
        };
    }
}
