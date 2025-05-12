package math.calculators;

import expressions.Expression;
import expressions.Fraction;
import expressions.Number;

public class NumberCalculator {
    static Expression addNumber(Number number, Expression expression) {
        if (expression instanceof Number n) {
            return new Number(number.getValue() + (n).getValue());
        } else if (expression instanceof Fraction f) {
            Expression tmp = new Number(number.getValue()).mul(f.getDenominator());
            return new Fraction ((f).getNumerator().add(tmp), (f).getDenominator());
        }
        return null;
    }

    static Expression subNumber(Number number, Expression expression) {
        if (expression instanceof Number n) {
            return new Number(number.getValue() - n.getValue());
        } else if (expression instanceof Fraction f) {
            Expression tmp = new Number(number.getValue()).mul(f.getDenominator());
            return new Fraction ((f).getNumerator().sub(tmp), (f).getDenominator());
        }
        return null;
    }

    static Expression mulNumber(Number number, Expression expression) {
        if (expression instanceof Number n) {
            return new Number(number.getValue() * n.getValue());
        } else if (expression instanceof Fraction f) {
            return new Fraction(f.getNumerator().mul(number), f.getDenominator());
        }
        return null;
    }

    static Expression divNumber(Number number, Expression expression) {
        if (expression instanceof Number n) {
            if (number.getValue() % n.getValue() == 0) {
                return new Number(number.getValue() / n.getValue());
            } else {
                return new Fraction(new Number(number.getValue()), new Number(n.getValue()));
            }
        } else if (expression instanceof Fraction f) {
            Expression tmp = new Fraction(f.getDenominator(), f.getNumerator());
            return mulNumber(number, tmp);
        }
        return null;
    }
}
