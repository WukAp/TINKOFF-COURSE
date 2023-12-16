package edu.hw10.Task10.randomGenerators;

import edu.hw10.Task10.annotations.NotNull;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

public class RandomObjectGenerator {
    private final List<RandomSimpleGenerator<?>> randomSimpleGenerators;

    public RandomObjectGenerator() {
        this.randomSimpleGenerators = new DefaultRandomSimpleGenerators().getDefaultRandomGenerators();
    }

    public RandomObjectGenerator(List<RandomSimpleGenerator<?>> randomGenerators) {
        this.randomSimpleGenerators = randomGenerators;
    }

    /**
     * creates an object using constructors
     * Fill all parameters without null
     *
     * @param generatedClass the class to be generated
     * @return the Object that may be cast to generatedClass
     */
    public Object nextObject(Class<?> generatedClass) {
        var tryCastSimpleClass = nextSimpleObjectOrNull(generatedClass);
        if (tryCastSimpleClass != null) {
            return tryCastSimpleClass;
        }
        firstLoop:
        for (var constructor : generatedClass.getConstructors()) {
            Parameter[] constructorsParams = constructor.getParameters();
            Object[] params = new Object[constructorsParams.length];

            for (int i = 0; i < params.length; i++) {
                var obj = nextSimpleObjectOrNull(constructorsParams[i].getType(), constructorsParams[i]);
                if (obj == null) {
                    continue firstLoop;
                }
                params[i] = obj;
            }
            try {
                return generatedClass.getConstructor(constructor.getParameterTypes()).newInstance(params);
            } catch (Exception ignored) {

            }
        }
        throw new RuntimeException("Can't create an Object");
    }

    /**
     * creates an object using method
     * Fill parameter by Simply Objects or Null if the parameter have no @NotNull annotation
     *
     * @param method the factory method. Should be static.
     * @return the Object that may be cast to generatedClass
     */
    public Object nextObject(Method method) {
        Parameter[] methodParameters = method.getParameters();
        Object[] params = new Object[methodParameters.length];

        for (int i = 0; i < params.length; i++) {
            var obj = nextSimpleObjectOrNull(methodParameters[i].getType(), methodParameters[i]);
            if (obj == null && methodParameters[i].isAnnotationPresent(NotNull.class)) {
                throw new RuntimeException("Can't create parameters with type " + methodParameters[i].getType());
            }
            params[i] = obj;
        }
        try {
            return method.invoke(null, params);
        } catch (Exception e) {
            throw new RuntimeException("Can't invoke method", e);
        }
    }

    public Object nextSimpleObjectOrNull(Class<?> generatedClass) {
        for (var generator : randomSimpleGenerators) {
            if (generator.isMatch(generatedClass)) {
                return generator.next();
            }
        }
        return null;
    }

    private Object nextSimpleObjectOrNull(Class<?> generatedClass, Parameter parameter) {
        for (var generator : randomSimpleGenerators) {
            if (generator.isMatch(generatedClass)) {
                return generator.next(parameter);
            }
        }
        return null;
    }

    public Object nextSimpleObjectOrThrow(Class<?> generatedClass) {
        var obj = nextSimpleObjectOrNull(generatedClass);
        if (obj == null) {
            throw new RuntimeException("Can't generate class" + generatedClass.getName());
        }
        return obj;
    }

}
