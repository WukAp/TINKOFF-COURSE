package edu.hw2.Task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CallingInfoUtilsTest {

    @Test void getCallerClassAndMethodName() {
        Assertions.assertEquals(
            new CallingInfoUtils.CallingInfo("edu.hw2.Task4.CallingInfoUtilsTest", "getCallerClassAndMethodName"),
            CallingInfoUtils.getCallerClassAndMethodName()
        );
    }

    @Test void getCallerClassAndMethodNameAnother() {
        Assertions.assertEquals(new CallingInfoUtils.CallingInfo("edu.hw2.Task4.CallingInfoUtilsTest",
                "getCallerClassAndMethodNameAnother"
            ),
            CallingInfoUtils.getCallerClassAndMethodName()
        );
    }
}
