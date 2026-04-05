package expressions;

import expressions.settings.ExpressionSettings;

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
        ExpressionSettings expressionSettings = getSettings();
        StringBuilder stringBuilder = new StringBuilder();

        if (expressionSettings.isRenderingLeadingPluses() && this.value >= 0) {
            stringBuilder.append("+");
        }
        if (expressionSettings.isRenderingOnes()) {
            stringBuilder.append(this.value);
            return stringBuilder.toString();
        }
        if (this.value == -1) {
            stringBuilder.append("-");
            return stringBuilder.toString();
        }
        if (this.value == 1) {
            return stringBuilder.toString();
        }
        stringBuilder.append(this.value);
        return stringBuilder.toString();
    }

    @Override
    public Expression add(Expression expression) {
        if (expression instanceof Number number) {
            return new Number(this.value + number.value);
        }
        return expression.add(this);
    }

    @Override
    public Expression sub(Expression expression) {
        if (expression instanceof Number number) {
            return new Number(this.value - number.value);
        }
        return expression.sub(this).mul(new Number(-1));
    }

    @Override
    public Expression mul(Expression expression) {
        if (expression instanceof Number number) {
            return new Number(this.value * number.value);
        }
        return expression.mul(this);
    }

    @Override
    public Expression div(Expression expression) {
        if (expression instanceof Number n) {
            if (this.value % n.value != 0) {
                return new Fraction(this.value, n.value);
            }
            return new Number(this.value / n.value);
        }
        if (expression instanceof Fraction fraction) {
            return this.mul(fraction.getReciprocal());
        }
        return this.mul(new Fraction(1, expression));
    }

    @Override
    public Expression getGCD(Expression expression) {
        if (expression instanceof Number number) {
            return new Number(getGCD(number.value));
        }
        return expression.getGCD(this);
    }

    @Override
    public Expression copy() {
        return new Number(this.value);
    }

    public int getValue() {
        return value;
    }

    private int getGCD(int number) {
        int x = Math.abs(this.value);
        int y = Math.abs(number);
        while (y != 0) {
            if (x > y) {
                x = x - y;
            } else {
                y = y - x;
            }
        }
        return x;
    }
}
