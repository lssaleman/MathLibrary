package math.calculators;

import expressions.Expression;
import expressions.Fraction;
import expressions.Number;

public class FractionCalculator {
    static Expression addFraction(Fraction fraction, Expression expression) {
        if (expression instanceof Number n) {
            return NumberCalculator.addNumber(n, fraction);
        } else if (expression instanceof Fraction f) {
            Expression numerator = fraction.getNumerator().mul(f.getDenominator());
            numerator = numerator.add(f.getNumerator().mul(fraction.getDenominator()));
            Expression denominator = fraction.getDenominator().mul(f.getDenominator());
            return new Fraction(numerator, denominator);
        }
        return null;
    }

    static Expression subFraction(Fraction fraction, Expression expression) {
        if (expression instanceof Number n) {
            Expression tmp = n.mul(fraction.getDenominator());
            return new Fraction (fraction.getNumerator().sub(tmp), fraction.getDenominator());
        } else if (expression instanceof Fraction f) {
            Expression numerator = fraction.getNumerator().mul(f.getDenominator());
            numerator = numerator.sub(f.getNumerator().mul(fraction.getDenominator()));
            Expression denominator = fraction.getDenominator().mul(f.getDenominator());
            return new Fraction(numerator, denominator);
        }
        return null;
    }

    static Expression mulFraction(Fraction fraction, Expression expression) {
        if (expression instanceof Number n) {
            return NumberCalculator.mulNumber(n, fraction);
        } else if (expression instanceof Fraction f) {
            Expression numerator = fraction.getNumerator().mul(f.getNumerator());
            Expression denominator = fraction.getDenominator().mul(f.getDenominator());
            return new Fraction(numerator, denominator);
        }
        return null;
    }

    static Expression divFraction(Fraction fraction, Expression expression) {
        if (expression instanceof Number n) {
            Fraction tmp =  new Fraction(1, n.getValue());
            return FractionCalculator.mulFraction(tmp, fraction);
        } else if (expression instanceof Fraction f) {
            return FractionCalculator.mulFraction(fraction, f.getReciprocal());
        }
        return null;
    }
}
