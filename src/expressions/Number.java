package expressions;

import jdk.jfr.Experimental;

public class Number extends ExpressionModifier {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Number n) {
            return this.value == n.value;
        }
        return false;
    }

    @Override
    public String get() {
        return String.valueOf(value);
    }

    @Override
    public boolean isZero() {
        return value == 0;
    }

    @Override
    public boolean isPositive() {
        return value >= 0;
    }

    @Override
    public boolean isOne() {
        return value == 1;
    }

    @Override
    public boolean isMinusOne() {
        return value == -1;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Expression add(Expression expression) {
        if (expression instanceof Number n) {
            return new Number(n.value + this.value);
        }
        return expression.add(this);
    }

    @Override
    public Expression sub(Expression expression) {
        if (expression instanceof Number n) {
            return new Number(n.value - this.value);
        }
        return expression.sub(this).mul(new Number(-1));
    }

    @Override
    public Expression mul(Expression expression) {
        if (expression instanceof Number n) {
            return new Number(n.value * this.value);
        }
        return expression.mul(this);
    }

    @Override
    public Expression div(Expression expression) {
        if (expression instanceof Number n) {
            if (this.value % n.value != 0) {
                return new Fraction(this.value, n.value);
            }
            return new Number(n.value / this.value);
        }
        return expression.div(this);
    }

    public int getValue() {
        return value;
    }
}
