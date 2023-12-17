package edu.hw10.Task2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CacheHandler implements InvocationHandler {
    private final Object original;
    private final Data cacheData;

    CacheHandler(Object original, Data cacheData) {
        this.original = original;
        this.cacheData = cacheData;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class) && method.getDeclaredAnnotation(Cache.class).persist()) {
            var methodResult = method.invoke(original, args);
            cacheData.putCacheData(
                new Data.DataRecord(method, methodResult, method.getReturnType())
            );
            return methodResult;
        }
        return method.invoke(original, args);
    }
}
