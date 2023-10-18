package edu.hw2.Task4;

public class CallingInfoUtils {

    private static final int CALLER_METHOD_DEPTH = 1;

    /**
     * Hided Utility Class constructor
     */
    private CallingInfoUtils() {
    }


    /**
     * gets its caller info
     *
     * @return the CallingInfo with the className and methodName of caller
     */
    public static CallingInfo getCallerClassAndMethodName() {
        StackTraceElement[] stack = new Throwable().getStackTrace();
        if (stack.length > CALLER_METHOD_DEPTH) {
            return new CallingInfo(stack[CALLER_METHOD_DEPTH].getClassName(),
                stack[CALLER_METHOD_DEPTH].getMethodName()
            );
        }
        return null;
    }

    public record CallingInfo(String className, String methodName) {
    }

}
