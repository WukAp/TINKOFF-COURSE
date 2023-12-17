package edu.hw6.Task1;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class DiskMapTest {
    public static void deleteFileIfExists(Path path) throws IOException {
        if (Files.exists(path)) {
            Files.delete(path);
        }
    }

    public static DiskMap createNewDiskMapForTest(Path path) throws IOException {
        deleteFileIfExists(path);
        return new DiskMap(path);
    }

    @Test
    void constructor() throws IOException {

        Path path = Paths.get("src/main/resources/testFiles/testFileConstructor.txt");

        assertDoesNotThrow(() -> new DiskMap(path));
        assertTrue(new DiskMap(path).isEmpty());

        Files.delete(path);
    }

    @Test
    void change() throws IOException {
        Path path = Paths.get("src/main/resources/testFiles/testFile.txt");
        DiskMap diskMap = createNewDiskMapForTest(path);
        assertTrue(diskMap.isEmpty());

        diskMap.put("1", "one");
        assertFalse(diskMap.isEmpty());
        assertEquals(1, diskMap.size());

        diskMap.put("2", "two");
        assertFalse(diskMap.isEmpty());
        assertEquals(2, diskMap.size());
        assertEquals("two", diskMap.get("2"));

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

    @Test
    void dataMethods() throws IOException {
        DiskMap diskMap1 = createNewDiskMapForTest(Paths.get("src/main/resources/testFiles/testFile.txt"));
        DiskMap diskMap2 = createNewDiskMapForTest(Paths.get("src/main/resources/testFiles/testFile2.txt"));
        assertTrue(diskMap1.equals(diskMap1));
        assertEquals(diskMap1.hashCode(), diskMap1.hashCode());

        assertFalse(diskMap1.equals(diskMap2));
        assertFalse(diskMap1.equals(new Object()));
        assertFalse(diskMap1.equals(null));

        Files.delete(Paths.get("src/main/resources/testFiles/testFile.txt"));

        Files.delete(Paths.get("src/main/resources/testFiles/testFile2.txt"));

    }

    @Test
    void changeThrow() throws IOException {
        Path path = Paths.get("src/main/resources/testFiles/testFile.txt");
        DiskMap diskMap = createNewDiskMapForTest(path);
        if (Files.exists(path)) {
            Files.delete(path);
        }
        assertThrows(RuntimeException.class, () -> diskMap.put("2", "two"));
        assertThrows(RuntimeException.class, diskMap::size);
        assertThrows(RuntimeException.class, diskMap::isEmpty);
        assertThrows(RuntimeException.class, diskMap::keySet);
        assertThrows(RuntimeException.class, diskMap::values);
        assertThrows(RuntimeException.class, diskMap::entrySet);
        assertThrows(RuntimeException.class, () -> diskMap.containsKey("1"));
        assertThrows(RuntimeException.class, () -> diskMap.containsValue("1"));
        assertThrows(RuntimeException.class, () -> diskMap.get("1"));
        assertThrows(RuntimeException.class, () -> diskMap.put("1", "one"));
        assertThrows(RuntimeException.class, () -> diskMap.putAll(new HashMap<>()));
        assertThrows(RuntimeException.class, () -> diskMap.remove("1"));

    }

}
