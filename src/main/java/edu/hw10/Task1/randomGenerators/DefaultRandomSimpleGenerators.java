package edu.hw10.Task1.randomGenerators;

import edu.hw10.Task1.annotations.Max;
import edu.hw10.Task1.annotations.Min;
import java.lang.reflect.Parameter;
import java.security.SecureRandom;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

public class DefaultRandomSimpleGenerators {
    private static final int DEFAULT_STRING_SIZE = 15;
    private final SecureRandom random = new SecureRandom();

    public List<RandomSimpleGenerator<?>> getDefaultRandomGenerators() {
        return List.of(getIntegerRandomGenerator(), getDoubleRandomGenerator(), getLongRandomGenerator(),
            getBooleanRandomGenerator(), getFloatRandomGenerator(),
            getStringRandomGenerator(), getCharacterRandomGenerator()
        );
    }

    public RandomSimpleGenerator<Integer> getIntegerRandomGenerator() {
        return new RandomSimpleGenerator<>() {
            @Override
            public Integer next(Parameter parameter) {
                int max = parameter.isAnnotationPresent(Max.class) ? parameter.getAnnotation(Max.class).value()
                    : Integer.MAX_VALUE;
                int min = parameter.isAnnotationPresent(Min.class) ? parameter.getAnnotation(Min.class).value()
                    : Integer.MIN_VALUE;

                return random.nextInt(min, max);
            }

            @Override
            public Integer next() {
                return random.nextInt();
            }

            @Override
            public Class<?> getTClass() {
                return Integer.class;
            }
        };
    }

    public RandomSimpleGenerator<Double> getDoubleRandomGenerator() {

        return new RandomSimpleGenerator<>() {
            @Override
            public Double next() {
                return random.nextDouble();
            }

            @Override
            public Double next(Parameter parameter) {
                double max = parameter.isAnnotationPresent(Max.class) ? parameter.getAnnotation(Max.class).value()
                    : Double.MAX_VALUE;
                double min = parameter.isAnnotationPresent(Min.class) ? parameter.getAnnotation(Min.class).value()
                    : Double.MIN_VALUE;
                return random.nextDouble(min, max);
            }

            @Override
            public Class<?> getTClass() {
                return Double.class;
            }
        };
    }

    public RandomSimpleGenerator<Long> getLongRandomGenerator() {
        return new RandomSimpleGenerator<>() {

            @Override
            public Long next() {
                return random.nextLong();
            }

            @Override
            public Long next(Parameter parameter) {
                long max = parameter.isAnnotationPresent(Max.class) ? parameter.getAnnotation(Max.class).value()
                    : Long.MAX_VALUE;
                long min = parameter.isAnnotationPresent(Min.class) ? parameter.getAnnotation(Min.class).value()
                    : Long.MIN_VALUE;
                return random.nextLong(min, max);
            }

            @Override
            public Class<?> getTClass() {
                return Long.class;
            }
        };
    }

    public RandomSimpleGenerator<Boolean> getBooleanRandomGenerator() {
        return new RandomSimpleGenerator<>() {
            @Override
            public Boolean next() {
                return random.nextBoolean();
            }

            @Override
            public Class<?> getTClass() {
                return Boolean.class;
            }
        };
    }

    public RandomSimpleGenerator<Float> getFloatRandomGenerator() {
        return new RandomSimpleGenerator<>() {
            @Override
            public Float next() {
                return random.nextFloat();
            }

            @Override
            public Float next(Parameter parameter) {

                float max = parameter.isAnnotationPresent(Max.class) ? parameter.getAnnotation(Max.class).value()
                    : Float.MAX_VALUE;
                float min = parameter.isAnnotationPresent(Min.class) ? parameter.getAnnotation(Min.class).value()
                    : Float.MIN_VALUE;

                return random.nextFloat(min, max);
            }

            @Override
            public Class<?> getTClass() {
                return Float.class;
            }
        };
    }

    public RandomSimpleGenerator<String> getStringRandomGenerator() {
        return new RandomSimpleGenerator<>() {
            @Override
            public String next() {
                return RandomStringUtils.randomAscii(DEFAULT_STRING_SIZE);
            }

            @Override
            public Class<?> getTClass() {
                return String.class;
            }
        };
    }

    public RandomSimpleGenerator<Character> getCharacterRandomGenerator() {
        return new RandomSimpleGenerator<>() {
            @Override
            public Character next() {
                return RandomStringUtils.randomAlphabetic(1).charAt(0);
            }

            @Override
            public Class<?> getTClass() {
                return Character.class;
            }
        };
    }

}
