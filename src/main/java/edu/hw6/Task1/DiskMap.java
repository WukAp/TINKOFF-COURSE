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
        doOrThrow(this::readMap);
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        doOrThrow(this::readMap);
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        doOrThrow(this::readMap);
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        doOrThrow(this::readMap);
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        doOrThrow(this::readMap);
        return map.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        doOrThrow(this::readMap);
        String result = map.put(key, value);

        doOrThrow(this::writeMap);

        return result;
    }

    @Override
    public String remove(Object key) {
        doOrThrow(this::readMap);
        String result = map.remove(key);
        if (result != null) {
            doOrThrow(this::writeMap);
        }
        return result;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        doOrThrow(this::readMap);
        map.putAll(m);
        doOrThrow(this::writeMap);
    }

    @Override
    public void clear() {
        map.clear();
        doOrThrow(this::writeMap);
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        doOrThrow(this::readMap);
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        doOrThrow(this::readMap);
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        doOrThrow(this::readMap);
        return map.entrySet();
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

    private void doOrThrow(ThrowableIOExceptionAction action) {
        try {
            action.doAction();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Map<String, String> readMap() throws IOException {
        try (FileInputStream fileInput = new FileInputStream(path.toString())) {
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
        try (FileOutputStream myFileOutStream = new FileOutputStream(path.toString())) {
            ObjectOutputStream myObjectOutStream
                = new ObjectOutputStream(myFileOutStream);
            myObjectOutStream.writeObject(mapper.writeValueAsString(map));
            myObjectOutStream.close();
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    @FunctionalInterface
    private interface ThrowableIOExceptionAction {
        void doAction() throws IOException;
    }
}
