package edu.hw10.Task10.randomGenerators;

import java.lang.reflect.Parameter;

public interface RandomSimpleGenerator<T> {
    T next();

    default T next(Parameter parameter) {
        return next();
    }

    Class<?> getTClass();

    default boolean isMatch(Class<?> matchedClass) {
        return getTClass().isAssignableFrom(matchedClass);
    }
}

