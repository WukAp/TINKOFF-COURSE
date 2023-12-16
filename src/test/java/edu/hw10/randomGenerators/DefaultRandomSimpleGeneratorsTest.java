package edu.hw10.randomGenerators;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultRandomSimpleGeneratorsTest {
    private final DefaultRandomSimpleGenerators generators = new DefaultRandomSimpleGenerators();

    @Test
    void getDefaultRandomGenerators() {
        assertDoesNotThrow(() -> generators.getDefaultRandomGenerators().forEach(RandomSimpleGenerator::next));
    }

    @Test
    void getDoubleRandomGenerator() {
        assertInstanceOf(Double.class, generators.getDoubleRandomGenerator().next());
        assertTrue(generators.getDoubleRandomGenerator().isMatch(Double.class));
        assertFalse(generators.getDoubleRandomGenerator().isMatch(Float.class));
        assertFalse(generators.getDoubleRandomGenerator().isMatch(String.class));
        assertFalse(generators.getDoubleRandomGenerator().isMatch(Integer.class));
        assertFalse(generators.getDoubleRandomGenerator().isMatch(Character.class));
        assertFalse(generators.getDoubleRandomGenerator().isMatch(Boolean.class));
        assertFalse(generators.getDoubleRandomGenerator().isMatch(Long.class));
    }

    @Test
    void getLongRandomGenerator() {
        assertInstanceOf(Long.class, generators.getLongRandomGenerator().next());
        assertTrue(generators.getLongRandomGenerator().isMatch(Long.class));
        assertFalse(generators.getLongRandomGenerator().isMatch(Float.class));
        assertFalse(generators.getLongRandomGenerator().isMatch(String.class));
        assertFalse(generators.getLongRandomGenerator().isMatch(Integer.class));
        assertFalse(generators.getLongRandomGenerator().isMatch(Character.class));
        assertFalse(generators.getLongRandomGenerator().isMatch(Double.class));
        assertFalse(generators.getLongRandomGenerator().isMatch(Boolean.class));
    }

    @Test
    void getBooleanRandomGenerator() {
        assertInstanceOf(Boolean.class, generators.getBooleanRandomGenerator().next());
        assertTrue(generators.getBooleanRandomGenerator().isMatch(Boolean.class));
        assertFalse(generators.getBooleanRandomGenerator().isMatch(Float.class));
        assertFalse(generators.getBooleanRandomGenerator().isMatch(String.class));
        assertFalse(generators.getBooleanRandomGenerator().isMatch(Integer.class));
        assertFalse(generators.getBooleanRandomGenerator().isMatch(Character.class));
        assertFalse(generators.getBooleanRandomGenerator().isMatch(Double.class));
        assertFalse(generators.getBooleanRandomGenerator().isMatch(Long.class));
    }

    @Test
    void getFloatRandomGenerator() {
        assertInstanceOf(Float.class, generators.getFloatRandomGenerator().next());
        assertTrue(generators.getFloatRandomGenerator().isMatch(Float.class));
        assertFalse(generators.getFloatRandomGenerator().isMatch(String.class));
        assertFalse(generators.getFloatRandomGenerator().isMatch(Integer.class));
        assertFalse(generators.getFloatRandomGenerator().isMatch(Character.class));
        assertFalse(generators.getFloatRandomGenerator().isMatch(Double.class));
        assertFalse(generators.getFloatRandomGenerator().isMatch(Long.class));
        assertFalse(generators.getFloatRandomGenerator().isMatch(Boolean.class));
    }

    @Test
    void getStringRandomGenerator() {
        assertInstanceOf(String.class, generators.getStringRandomGenerator().next());
        assertTrue(generators.getStringRandomGenerator().isMatch(String.class));
        assertFalse(generators.getStringRandomGenerator().isMatch(Integer.class));
        assertFalse(generators.getStringRandomGenerator().isMatch(Float.class));
        assertFalse(generators.getStringRandomGenerator().isMatch(Character.class));
        assertFalse(generators.getStringRandomGenerator().isMatch(Double.class));
        assertFalse(generators.getStringRandomGenerator().isMatch(Long.class));
        assertFalse(generators.getStringRandomGenerator().isMatch(Boolean.class));
    }

    @Test
    void getCharacterRandomGenerator() {
        assertInstanceOf(Character.class, generators.getCharacterRandomGenerator().next());
        assertTrue(generators.getCharacterRandomGenerator().isMatch(Character.class));
        assertFalse(generators.getCharacterRandomGenerator().isMatch(Integer.class));
        assertFalse(generators.getCharacterRandomGenerator().isMatch(Float.class));
        assertFalse(generators.getCharacterRandomGenerator().isMatch(String.class));
        assertFalse(generators.getCharacterRandomGenerator().isMatch(Double.class));
        assertFalse(generators.getCharacterRandomGenerator().isMatch(Long.class));
        assertFalse(generators.getCharacterRandomGenerator().isMatch(Boolean.class));
    }

    @Test
    void getIntegerRandomGenerator() {
        assertInstanceOf(Integer.class, generators.getIntegerRandomGenerator().next());
        assertTrue(generators.getIntegerRandomGenerator().isMatch(Integer.class));
        assertFalse(generators.getIntegerRandomGenerator().isMatch(Float.class));
        assertFalse(generators.getIntegerRandomGenerator().isMatch(String.class));
        assertFalse(generators.getIntegerRandomGenerator().isMatch(Double.class));
        assertFalse(generators.getIntegerRandomGenerator().isMatch(Long.class));
        assertFalse(generators.getIntegerRandomGenerator().isMatch(Boolean.class));
        assertFalse(generators.getIntegerRandomGenerator().isMatch(Character.class));
    }
}
