package edu.hw6.Task1;

import edu.hw6.Task2.FilesUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class DiskMapTest {

    @Test
    void constructor() throws IOException {

        Path path = Paths.get("testFiles/testFileConstructor.txt");

        assertDoesNotThrow(() -> new DiskMap(path));
        assertTrue( new DiskMap(path).isEmpty());

        Files.delete(path);
    }

    @Test
    void change() throws IOException {
        Path path = Paths.get("testFiles/testFile.txt");
        if (Files.exists(path)) {
            Files.delete(path);
        }
        DiskMap diskMap = new DiskMap(path);
        assertTrue(diskMap.isEmpty());

        diskMap.put("1", "one");
        assertFalse(diskMap.isEmpty());
        assertEquals(1, diskMap.size());

        diskMap.put("2", "two");
        assertFalse(diskMap.isEmpty());
        assertEquals(2, diskMap.size());

        assertTrue(diskMap.containsKey("1"));
        assertFalse(diskMap.containsKey("3"));

        assertArrayEquals(new String[] {"one", "two"}, diskMap.values().toArray());
        assertArrayEquals(new String[] {"1", "2"}, diskMap.keySet().toArray());
        assertEquals(2, diskMap.entrySet().size());

        assertTrue(diskMap.containsValue("one"));
        assertFalse(diskMap.containsValue("three"));

        assertEquals("two", diskMap.remove("2"));
        assertEquals(1, diskMap.size());

        diskMap.clear();
        assertTrue(diskMap.isEmpty());

        Map<String, String> map = new HashMap<>();
        map.put("3", "three");
        map.put("4", "four");
        diskMap.putAll(map);
        assertEquals(2, diskMap.entrySet().size());
        Files.delete(path);
    }
}
