package math.calculators;

import expressions.*;
import expressions.Number;

public class Control {

    public static Expression add(Expression first, Expression second) {
        if (first instanceof Number n) {
            return NumberCalculator.addNumber(n, second);
        } else if (first instanceof Fraction f) {
            return FractionCalculator.addFraction(f, second);
        }
        return null;
    }

    public static Expression sub(Expression first, Expression second) {
        if (first instanceof Number n) {
            return NumberCalculator.subNumber(n, second);
        } else if (first instanceof Fraction f) {
            return FractionCalculator.subFraction(f, second);
        }
        return null;
    }

    public static Expression mul(Expression first, Expression second) {
        if (first instanceof Number n) {
            return NumberCalculator.mulNumber(n, second);
        } else if (first instanceof Fraction f) {
            return FractionCalculator.mulFraction(f, second);
        }
        return null;
    }

    public static Expression div(Expression first, Expression second) {
        if (first instanceof Number n) {
            return NumberCalculator.divNumber(n, second);
        } else if (first instanceof Fraction f) {
            return FractionCalculator.divFraction(f, second);
        }
        return null;
    }
}
