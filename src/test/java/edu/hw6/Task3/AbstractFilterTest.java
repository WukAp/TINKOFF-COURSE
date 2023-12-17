package edu.hw6.Task3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.AccessMode;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

class AbstractFilterTest {
    public static final AbstractFilter regularFile = Files::isRegularFile;
    public static final AbstractFilter readable = Files::isReadable;
    @Test
    void filter() throws IOException {
MyFilters myFilters = new MyFilters();

        Path path = Paths.get("src/main/resources/testFiles");
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(myFilters.largerThan(100_000))
            .and(myFilters.magicNumber((char)0x89, 'P', 'N', 'G')
                .and(myFilters.globMatches("*.png"))
                .and(myFilters.regexContains("[-]")).and(myFilters.hasAttribute(AccessMode.READ)));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {

            assertFalse(entries.iterator().hasNext());
        }
        filter = regularFile
            .and(readable);

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            var iterator = entries.iterator();
            assertTrue(iterator.hasNext());
            assertEquals("src/main/resources/testFiles/images.jpeg", iterator.next().toString());
            assertFalse(iterator.hasNext());
        }
        filter = regularFile
            .and(readable).and(myFilters.regexContains("im")).and(myFilters.hasAttribute(AccessMode.READ));

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(path, filter)) {
            var iterator = entries.iterator();
            assertTrue(iterator.hasNext());
            assertEquals("src/main/resources/testFiles/images.jpeg", iterator.next().toString());
            assertFalse(iterator.hasNext());
        }
    }

}
