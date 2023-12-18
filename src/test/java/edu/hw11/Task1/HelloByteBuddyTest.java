package edu.hw11.Task1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloByteBuddyTest {
    @Test
    void generateNewByteBuddyClass() throws InstantiationException, IllegalAccessException {

        Class<?> ByteBuddyClass = new ByteBuddy()
            .subclass(Object.class)
            .method(ElementMatchers.isToString())
            .intercept(FixedValue.value("Hello, ByteBuddy!"))
            .make().load(getClass().getClassLoader()).getLoaded();

        assertEquals("Hello, ByteBuddy!", ByteBuddyClass.newInstance().toString());

    }
}
