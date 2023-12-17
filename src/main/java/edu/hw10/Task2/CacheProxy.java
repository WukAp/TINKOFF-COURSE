package edu.hw10.Task2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class CacheProxy {
    private final Data data;

    public CacheProxy() {
        this.data = new Data();
    }

    public Object create(Object original, Class<?> clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        Class<?>[] interfaces = clazz.getInterfaces();
        InvocationHandler invocationHandler = new CacheHandler(original, data);
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }

    public List<Data.DataRecord> getCacheData() {
        return data.getCacheData();
    }
}
