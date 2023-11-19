package edu.hw6.Task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FilesUtilsTest {

    @Test
    void clonePath() throws IOException {

        Path path = Paths.get("testFiles", "testFile.txt");
        if (Files.exists(path)) {
            Files.delete(path);
        }
        Files.createFile(path);

        FilesUtils filesUtils = new FilesUtils();
        List<Path> pathList = List.of(
            filesUtils.clonePath(path),
            filesUtils.clonePath(path),
            filesUtils.clonePath(path),
            filesUtils.clonePath(path)
        );

        assertEquals(Paths.get("testFiles", "testFile — копия.txt"), pathList.get(0));
        for (int i = 1; i < pathList.size(); i++) {
            assertEquals(Paths.get("testFiles", "testFile — копия (" + i + ").txt"), pathList.get(i));
        }


        for (int i = 1; i < pathList.size(); i++) {
            Files.delete(Paths.get("testFiles", "testFile — копия (" + i + ").txt"));
        }
        Files.delete(path);
        Files.delete(Paths.get("testFiles", "testFile — копия.txt"));
    }
}
