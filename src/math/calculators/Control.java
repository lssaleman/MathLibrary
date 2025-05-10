package math.calculators;

import expressions.*;
import expressions.Number;

public class Control {

    public static Expression add(Expression first, Expression second) {
        if (first instanceof Number n) {
            return NumberCalculator.addNumber(n, second);
        }
        return null;
    }

    public static Expression sub(Expression first, Expression second) {
        if (first instanceof Number n) {
            return NumberCalculator.subNumber(n, second);
        }
        return null;
    }

    public static Expression mul(Expression first, Expression second) {
        if (first instanceof Number n) {
            return NumberCalculator.mulNumber(n, second);
        }
        return null;
    }

    public static Expression div(Expression first, Expression second) {
        if (first instanceof Number n) {
            return NumberCalculator.divNumber(n, second);
        }
        return null;
    }
}
