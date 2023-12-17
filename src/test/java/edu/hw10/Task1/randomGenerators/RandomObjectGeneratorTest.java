package edu.hw10.Task1.randomGenerators;

import edu.hw10.Task1.annotations.NotNull;
import edu.hw10.Task1.annotations.Max;
import edu.hw10.Task1.annotations.Min;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class RandomObjectGeneratorTest {
    private final RandomObjectGenerator generator = new RandomObjectGenerator();

    @Test
    void nextObject() {
        assertInstanceOf(String.class, generator.nextObject(String.class));
        assertInstanceOf(Integer.class, generator.nextObject(Integer.class));
        assertInstanceOf(Dog.class, generator.nextObject(Dog.class));
        assertInstanceOf(Record1.class, generator.nextObject(Record1.class));
    }

    @Test
    void nextObjectExceptions() {
        assertThrows(RuntimeException.class, () -> generator.nextObject(Record3.class));
        assertDoesNotThrow(() -> generator.nextObject(Record4.class));
    }

    @Test
    void myGenerators() {
        RandomObjectGenerator myGenerator = new RandomObjectGenerator(List.of(new RandomSimpleGenerator<Record3>() {
            @Override
            public Record3 next() {
                return new Record3((Record2) generator.nextObject(Record2.class), 2, "Sasha");
            }

            @Override
            public Class<?> getTClass() {
                return Record3.class;
            }
        }));

        assertThrows(RuntimeException.class, () -> myGenerator.nextObject(Integer.class));
        assertDoesNotThrow(() -> myGenerator.nextObject(Record3.class));
    }

    @Test
    void nextSimpleObjectOrNull() {

        assertInstanceOf(String.class, generator.nextSimpleObjectOrNull(String.class));
        assertInstanceOf(Integer.class, generator.nextSimpleObjectOrNull(Integer.class));
        assertNull(generator.nextSimpleObjectOrNull(Dog.class));
    }

    @Test
    void nextSimpleObjectOrThrow() {
        assertInstanceOf(String.class, generator.nextSimpleObjectOrThrow(String.class));
        assertInstanceOf(Integer.class, generator.nextSimpleObjectOrThrow(Integer.class));
        assertThrows(RuntimeException.class, () -> generator.nextSimpleObjectOrThrow(Dog.class));
    }

    @Test
    void factories() throws NoSuchMethodException {
        DogWithFactory dogWithFactory = (DogWithFactory) generator.nextObject(
            DogWithFactory.class.getMethod(
                "create",
                String.class,
                Integer.class,
                Record1.class // will be null
            ));

        assertInstanceOf(DogWithFactory.class, dogWithFactory);
        assertTrue(dogWithFactory.age >= 0 && dogWithFactory.age < 30);
    }

    @Test
    void annotations() {
        RecordAnnotated recordAnnotated = (RecordAnnotated) generator.nextObject(RecordAnnotated.class);
        assertTrue(recordAnnotated.d() < 4 && recordAnnotated.d() >= 3);
        assertTrue(recordAnnotated.f() < 4 && recordAnnotated.f() >= 3);
        assertEquals(3, (int) recordAnnotated.i());
        assertEquals(3, (long) recordAnnotated.l());


        assertThrows(RuntimeException.class, () -> generator.nextObject(
            DogWithNotnullRecord.class.getMethod(
                "create",
                String.class,
                Integer.class,
                Record1.class //@NotNull
            )));
    }

    public record Record1(Double a, Integer b) {
    }

    public record Record2(Double a, Integer b, String str) {
    }

    public record Record3(Record2 a, Integer b, String str) {
    }

    public record Record4(Record2 a, Integer b, String str) {
        public Record4(Double a, Integer b, String str, Integer b2, String str2) {
            this(new Record2(a, b, str), b2, str2);
            throw new IllegalStateException();
        }

        public Record4(Double a, Integer b, String str) {
            this(new Record2(a, b, str), b, str);
        }
    }

    public record RecordAnnotated(@Min(3) @Max(4) Double d, @Min(3) @Max(4) Float f, @Min(3) @Max(4) Integer i,
                                  @Min(3) @Max(4) Long l) {
    }

    public static class Dog {
        private String name;
        private int age;

        public Dog(String name, @Min(0) @Max(30) Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    public static class DogWithFactory {
        private String name;
        private int age;

        private DogWithFactory(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public static DogWithFactory create(String name, @Min(0) @Max(30) Integer age, Record1 r) {
            return new DogWithFactory(name, age);
        }
    }

    public static class DogWithNotnullRecord {
        private String name;
        private int age;

        private DogWithNotnullRecord(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public static DogWithFactory create(String name, @Min(0) @Max(30) Integer age, @NotNull Record1 r) {
            return new DogWithFactory(name, age);
        }
    }
}
