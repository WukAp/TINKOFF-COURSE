package edu.hw6.Task1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private Map<String, String> map;
    private final Path path;

    private final ObjectMapper mapper;

    public DiskMap(Path path) throws IOException {
        mapper = new ObjectMapper();
        this.path = Paths.get(path.toUri());
        if (Files.exists(this.path)) {
            this.map = readMap();
        } else {
            this.map = new HashMap<>();
            Files.createFile(this.path);
            writeMap();
        }
    }

    @Override
    public int size() {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map.get(values());
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result = map.put(key, value);

        try {
            writeMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public String remove(Object key) {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String result = map.remove(key);
        if (result != null) {
            try {
                writeMap();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        map.putAll(m);
        try {
            writeMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        map.clear();
        try {
            writeMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        try {
            readMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return map.entrySet();
    }

    private Map<String, String> readMap() throws IOException {
        try (FileInputStream fileInput = new FileInputStream(path.toString());) {
            ObjectInputStream objectInput
                = new ObjectInputStream(fileInput);
            Map<String, String> newHashMap =
                (HashMap) mapper.readValue(objectInput.readObject().toString(), HashMap.class);
            objectInput.close();
            return newHashMap;
        } catch (IOException e) {
            throw new IOException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeMap() throws IOException {
        try (FileOutputStream myFileOutStream = new FileOutputStream(path.toString());) {
            ObjectOutputStream myObjectOutStream
                = new ObjectOutputStream(myFileOutStream);
            myObjectOutStream.writeObject(mapper.writeValueAsString(map));
            myObjectOutStream.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DiskMap diskMap = (DiskMap) o;
        return Objects.equals(path, diskMap.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }
}
