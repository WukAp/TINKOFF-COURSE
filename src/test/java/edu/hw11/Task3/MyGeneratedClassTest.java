package edu.hw11.Task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Opcodes;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyGeneratedClassTest {

    @Test
    void generateClass()
        throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> myClass = new ByteBuddy()
            .subclass(Object.class)
            .name("MyClass")
            .defineMethod("inc", long.class, Modifier.PUBLIC)
            .withParameters(int.class)
            .intercept(new Implementation() {
                @Override
                public ByteCodeAppender appender(Target target) {
                    return (methodVisitor, instrumentationContext, instrumentedMethod) -> {
                        methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
                        methodVisitor.visitInsn(Opcodes.I2L);
                        methodVisitor.visitInsn(Opcodes.LCONST_1);
                        methodVisitor.visitInsn(Opcodes.LADD);
                        methodVisitor.visitInsn(Opcodes.LRETURN);
                        methodVisitor.visitMaxs(4, 2);
                        return new ByteCodeAppender.Size(4, 2);
                    };
                }

                @Override
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            })
            .make()
            .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.INJECTION).getLoaded();

        Method m = myClass.getDeclaredMethod("inc", int.class);
        assertEquals(3L, m.invoke(myClass.newInstance(), 2));
    }
}
