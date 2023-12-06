package edu.hw6.Task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesUtils {
    public Path clonePath(Path path) throws IOException {
        if (!Files.exists(path)) {
            throw new IllegalArgumentException("file" + path + " does not exist");
        } else {
            String copiedFileName = path.getFileName().toString();
            Path newPath;
            do {
                copiedFileName = getNextPathName(copiedFileName);
                newPath = Paths.get((path.getParent() == null ? "" : path.getParent().toString()), copiedFileName);
            } while (Files.exists(newPath));
            Files.copy(path, newPath);
            return newPath;
        }
    }

    @SuppressWarnings("MagicNumber")
    private String getNextPathName(String namePathFile) {
        Matcher matcher = Pattern.compile("^([a-zA-z0-9]* — копия \\()(\\d*)(\\)\\..*)$").matcher(namePathFile);
        if (matcher.find()) {
            return matcher.group(1) + (Integer.parseInt(matcher.group(2)) + 1)
                + matcher.group(3);
        }

        matcher = Pattern.compile("^([a-zA-z0-9]* — копия)(\\..*)$").matcher(namePathFile);
        if (matcher.find()) {
            return matcher.group(1) + " (1)" + matcher.group(2);
        }
        matcher = Pattern.compile("^([a-zA-z0-9]*)(\\..*)$").matcher(namePathFile);
        if (matcher.find()) {
            return matcher.group(1) + " — копия" + matcher.group(2);
        }
        throw new IllegalArgumentException("Illegal path name");
    }
}
