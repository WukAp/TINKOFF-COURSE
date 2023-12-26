package edu.hw6.Task4;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static edu.hw6.Task1.DiskMapTest.deleteFileIfExists;
import static org.junit.jupiter.api.Assertions.*;

class ArrowsAccessTest {
    private final ArrowsAccess arrowsAccess = new ArrowsAccess();

    @Test
    void getPrintWriter() throws IOException {
        String text = "Programming is learned by writing programs. ― Brian Kernighan";
        Path path = Paths.get("src/main/resources/testFiles/testFileConstructor.txt");
        deleteFileIfExists(path);
        arrowsAccess.getPrintWriter(path.toString(), text);

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toString()))) {

            String line = reader.readLine();
            assertEquals(text, line);
            assertNull(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        deleteFileIfExists(path);
    }

}
