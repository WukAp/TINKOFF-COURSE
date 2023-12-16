package edu.hw10.Task2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private final List<DataRecord> cacheData = new ArrayList<>();

    public List<DataRecord> getCacheData() {
        return cacheData;
    }

    public void putCacheData(DataRecord dataRecord) {
        cacheData.add(dataRecord);
    }

    public record DataRecord(Method method, Object returnValue, Class<?> returnValueClass) {
    }
}
