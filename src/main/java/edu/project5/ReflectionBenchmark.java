package edu.project5;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
public class ReflectionBenchmark {

    @SuppressWarnings({"MagicNumber", "UncommentedMain"})
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(ReflectionBenchmark.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(5))
            .measurementIterations(1)
            .measurementTime(TimeValue.seconds(5))
            .build();

        new Runner(options).run();
    }

    private Student student;
    private Method method;
    private MethodHandle concatMH;
    private StudentWithName callSite;
    private final String methodName = "name";

    @Setup
    public void setup() throws Throwable {
        student = new Student("Alexander", "Biryukov");
        method = Student.class.getDeclaredMethod(methodName);

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(String.class);
        concatMH = lookup.findVirtual(Student.class, methodName, mt);

        var factoryType = MethodType.methodType(StudentWithName.class);
        var interfaceMethodType = MethodType.methodType(
            String.class, Student.class
        );
        var dynamic = MethodType.methodType(String.class, Student.class);
        callSite = (StudentWithName) LambdaMetafactory.metafactory(
            lookup,
            "get",
            factoryType,
            interfaceMethodType,
            concatMH,
            dynamic
        ).getTarget().invokeExact();
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void reflection(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
        String name = (String) method.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void invokeMethodHandles(Blackhole bh) throws Throwable {
        String name = (String) concatMH.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void invokeLambdaMetafactory(Blackhole bh) throws Throwable {
        String name = callSite.get(student);
        bh.consume(name);
    }

    record Student(String name, String surname) {
    }

    public interface StudentWithName {
        String get(Student student);
    }
}
