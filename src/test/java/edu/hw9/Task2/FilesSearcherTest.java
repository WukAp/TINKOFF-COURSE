package edu.hw9.Task2;

import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class FilesSearcherTest {

    @Test
    void getAmountOfFilesAsync() { //48ms
        FilesSearcher filesSearcher = new FilesSearcher();
        assertEquals(
            6003,
            filesSearcher.getAmountOfFileAsync(new File("/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"))
        );
        assertEquals(
            1500,
            filesSearcher.getAmountOfFileAsync(new File(
                "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9/directoryWith1500Files"))
        );
    }

    @Test
    void getAmountOfFilesSync() {//76ms
        FilesSearcher filesSearcher = new FilesSearcher();
        assertEquals(
            6003,
            filesSearcher.getAmountOfFileSync(new File("/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"))
        );
        assertEquals(
            1500,
            filesSearcher.getAmountOfFileSync(new File(
                "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9/directoryWith1500Files"))
        );
    }

    @Test
    void isDirectoryContainsMoreThen1000Files() {
        FilesSearcher filesSearcher = new FilesSearcher();
        assertTrue(
            filesSearcher.getAmountOfFileSync(new File("/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9")) > 1000
        );
        assertTrue(
            filesSearcher.getAmountOfFileSync(new File(
                "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9/directoryWith1500Files")) > 1000
        );
    }

    @Test
    void getFileByPredicateAsync() {//119ms
        FilesSearcher filesSearcher = new FilesSearcher();
        assertEquals(
            6002,
            filesSearcher.getFileByPredicateAsync(
                new File(
                    "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"),
                (file) -> file.getName().matches(".*\\.txt")
            ).size()
        );
        assertEquals(
            1,
            filesSearcher.getFileByPredicateAsync(
                new File(
                    "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"),
                (file) -> file.getName().matches(".*\\.jpeg")
            ).size()
        );
        assertEquals(
            0,
            filesSearcher.getFileByPredicateAsync(
                new File(
                    "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"),
                (file) -> file.getName().matches(".*\\.png")
            ).size()
        );
        assertEquals(
            1,
            filesSearcher.getFileByPredicateAsync(
                new File(
                    "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"),
                (file) -> file.length() == 4571
            ).size()
        );
    }

    @Test
    void getFileByPredicateSync() { //253ms
        FilesSearcher filesSearcher = new FilesSearcher();
        assertEquals(
            6002,
            filesSearcher.getFileByPredicateSync(
                new File(
                    "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"),
                (file) -> file.getName().matches(".*\\.txt")
            ).size()
        );
        assertEquals(
            1,
            filesSearcher.getFileByPredicateSync(
                new File(
                    "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"),
                (file) -> file.getName().matches(".*\\.jpeg")
            ).size()
        );
        assertEquals(
            0,
            filesSearcher.getFileByPredicateSync(
                new File(
                    "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"),
                (file) -> file.getName().matches(".*\\.png")
            ).size()
        );
        assertEquals(
            1,
            filesSearcher.getFileByPredicateSync(
                new File(
                    "/home/wake/IdeaProjects/TINKOFF-COURSE/testFilesForHw9"),
                (file) -> file.length() == 4571
            ).size()
        );
    }
}
