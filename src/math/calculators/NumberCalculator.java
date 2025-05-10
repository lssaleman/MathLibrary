package math.calculators;

import expressions.Expression;
import expressions.Fraction;
import expressions.Number;

public class NumberCalculator {
    static Expression addNumber(expressions.Number number, Expression expression) {
        if (expression instanceof expressions.Number n) {
            return new expressions.Number(number.getValue() + (n).getValue());
        } else if (expression instanceof Fraction f) {
            Expression tmp = new expressions.Number(number.getValue()).mul(f.getDenominator());
            return new Fraction ((f).getNumerator().add(tmp), (f).getDenominator());
        }
        return null;
    }

    static Expression subNumber(expressions.Number number, Expression expression) {
        if (expression instanceof expressions.Number n) {
            return new expressions.Number(number.getValue() - n.getValue());
        } else if (expression instanceof Fraction f) {
            Expression tmp = new expressions.Number(number.getValue()).mul(f.getDenominator());
            return new Fraction ((f).getNumerator().sub(tmp), (f).getDenominator());
        }
        return null;
    }

    static Expression mulNumber(expressions.Number number, Expression expression) {
        if (expression instanceof expressions.Number n) {
            return new expressions.Number(number.getValue() * n.getValue());
        } else if (expression instanceof Fraction f) {
            return new Fraction(f.getNumerator().mul(new expressions.Number(number.getValue())), f.getDenominator().mul(new expressions.Number(1)));
        }
        return null;
    }

    static Expression divNumber(expressions.Number number, Expression expression) {
        if (expression instanceof expressions.Number n) {
            if (number.getValue() % n.getValue() == 0) {
                return new expressions.Number(number.getValue() / n.getValue());
            } else {
                return new Fraction(new expressions.Number(number.getValue()), new Number(n.getValue()));
            }
        } else if (expression instanceof Fraction f) {
            Expression tmp = new Fraction(f.getDenominator(), f.getNumerator());
            return mulNumber(number, tmp);
        }
        return null;
    }
}
