package edu.hw4;

public sealed abstract class ValidationError extends Exception {
    public abstract String getProblemField();

    @Override public String toString() {
        return getProblemField();
    }

    public static final class IllegalAgeArgumentException extends ValidationError {
        @Override
        public String getProblemField() {
            return "age";
        }
    }

    public static final class IllegalHeightArgumentException extends ValidationError {
        @Override
        public String getProblemField() {
            return "height";
        }
    }

    public static final class IllegalWeightArgumentException extends ValidationError {
        @Override
        public String getProblemField() {
            return "weight";
        }
    }

    public static final class NullPointerNameException extends ValidationError {
        @Override
        public String getProblemField() {
            return "name";
        }
    }

    public static final class NullPointerTypeException extends ValidationError {
        @Override
        public String getProblemField() {
            return "type";
        }
    }

    public static final class NullPointerSexException extends ValidationError {
        @Override
        public String getProblemField() {
            return "sex";
        }
    }
}
