package edu.hw2.Task1;

import edu.hw2.Task1.Expr.Addition;
import edu.hw2.Task1.Expr.Constant;
import edu.hw2.Task1.Expr.Exponent;
import edu.hw2.Task1.Expr.Multiplication;
import edu.hw2.Task1.Expr.Negate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExprTest {

    @Test
    void evaluate() {
        var two = new Constant.Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        Assertions.assertEquals(2, two.evaluate());
        Assertions.assertEquals(4, four.evaluate());
        Assertions.assertEquals(-1, negOne.evaluate());
        Assertions.assertEquals(6, sumTwoFour.evaluate());
        Assertions.assertEquals(-6, mult.evaluate());
        Assertions.assertEquals(36, exp.evaluate());
        Assertions.assertEquals(37, res.evaluate());
    }
}
