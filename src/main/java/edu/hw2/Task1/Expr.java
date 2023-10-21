package edu.hw2.Task1;

public sealed interface Expr {
    /**
     * evaluates expression
     *
     * @return expression values
     */
    double evaluate();

    /**
     * expression for the constant of a number
     *
     * @param value the primitive or Expr number
     */
    public record Constant(double value) implements Expr {
        public Constant(Constant constant) {
            this(constant.evaluate());
        }

        @Override
        public double evaluate() {
            return value;
        }
    }

    /**
     * expression for the negation of a number
     *
     * @param value the primitive or Expr number
     */
    public record Negate(double value) implements Expr {
        public Negate(Expr constant) {
            this(constant.evaluate());
        }

        @Override
        public double evaluate() {
            return -value;
        }
    }

    /**
     * expression for the exponent
     *
     * @param base     the primitive or Expr number
     * @param exponent the primitive or Expr number
     */
    public record Exponent(double base, double exponent) implements Expr {
        public Exponent(Expr baseConstant, Expr exponentConstant) {
            this(baseConstant.evaluate(), exponentConstant.evaluate());
        }

        public Exponent(double base, Expr constant2) {
            this(base, constant2.evaluate());
        }

        public Exponent(Expr baseConstant, double exponent) {
            this(baseConstant.evaluate(), exponent);
        }

        @Override
        public double evaluate() {
            return Math.pow(base, exponent);
        }
    }

    /**
     * expression for the addition  of numbers
     *
     * @param value1 the primitive or Expr number
     * @param value2 the primitive or Expr number
     */
    public record Addition(double value1, double value2) implements Expr {
        public Addition(Expr constant1, Expr constant2) {
            this(constant1.evaluate(), constant2.evaluate());
        }

        public Addition(double value1, Expr constant2) {
            this(value1, constant2.evaluate());
        }

        public Addition(Expr constant1, double value2) {
            this(constant1.evaluate(), value2);
        }

        @Override
        public double evaluate() {
            return value1 + value2;
        }
    }

    /**
     * expression for the multiplication  of numbers
     *
     * @param value1 the primitive or Expr number
     * @param value2 the primitive or Expr number
     */
    public record Multiplication(double value1, double value2) implements Expr {
        public Multiplication(Expr constant1, Expr constant2) {
            this(constant1.evaluate(), constant2.evaluate());
        }

        public Multiplication(double value1, Expr constant2) {
            this(value1, constant2.evaluate());
        }

        public Multiplication(Expr constant1, double value2) {
            this(constant1.evaluate(), value2);
        }

        @Override
        public double evaluate() {
            return value1 * value2;
        }
    }
}
