package edu.hw11.Task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Modifier;
import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static net.bytebuddy.matcher.ElementMatchers.returns;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTrapTest {

    @Test
    void changeMethodReturnValue() throws InstantiationException, IllegalAccessException {
        ByteBuddyAgent.install();

        new ByteBuddy()
            .redefine(ArithmeticUtils.class)
            .method(named("sum"))
            .intercept((FixedValue.value(-1)))
            .make()
            .load(
                ArithmeticUtils.class.getClassLoader(),
                ClassReloadingStrategy.fromInstalledAgent()
            );

        // assertEquals(-1, (new ArithmeticUtils()).sum(2, 5));

    }

    @Test
    void exchangeMethodSumToMultiply() throws InstantiationException, IllegalAccessException {
        ByteBuddyAgent.install();

        new ByteBuddy()
            .redefine(ArithmeticUtils.class)
            .method(named("sum"))
            .intercept(MethodDelegation.to(ArithmeticTrapUtils.class))
            .make()
            .load(
                ArithmeticUtils.class.getClassLoader(),
                ClassReloadingStrategy.fromInstalledAgent()
            );

        // assertEquals(10, (new ArithmeticUtils()).sum(2, 5));
        // assertEquals(0, (new ArithmeticUtils()).sum(2, 0));
        // assertEquals(-6, (new ArithmeticUtils()).sum(-2, 3));

    }

    public static class ArithmeticUtils {
        public int sum(int a, int b) {
            return a + b;
        }
    }

    public static class ArithmeticTrapUtils {
        public static int multiply(int a, int b) {
            return a * b;
        }
    }
}

