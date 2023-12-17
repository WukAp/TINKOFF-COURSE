package edu.hw10.Task2;

import org.junit.jupiter.api.Test;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CacheHandlerTest {
    CacheProxy cacheProxy = new CacheProxy();

    @Test
    void invoke() throws NoSuchMethodException, InterruptedException {
        Example original = new Example();
        ExampleImpl reader = (ExampleImpl) cacheProxy.create(original, original.getClass());
        var int42 = reader.get42();
        var a = reader.getA();
        var b = reader.getB(); // without @cache
        var cacheData = cacheProxy.getCacheData();
        assertEquals(2, cacheData.size());
        assertTrue(cacheData.contains(new Data.DataRecord(
            ExampleImpl.class.getDeclaredMethod("get42", null),
            int42,
            Integer.class
        )));
        assertTrue(cacheData.contains(new Data.DataRecord(
            ExampleImpl.class.getDeclaredMethod("getA", null),
            a,
            Character.class
        )));
        assertFalse(cacheData.contains(new Data.DataRecord(
            ExampleImpl.class.getDeclaredMethod("getB", null),
            b,
            Character.class
        )));

    }

    interface ExampleImpl {
        @Cache
        default Integer get42() {
            return 42;
        }

        @Cache
        default Character getA() {
            return 'A';
        }

        default Character getB() {
            return 'B';
        }

    }

    static class Example implements ExampleImpl {

    }
}
