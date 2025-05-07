package values;

public class Number extends ExpressionModifier implements Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
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
    public Expression add(Expression v) {
        if (v instanceof Number n) {
            return new Number(value + (n).getValue());
        } else if (v instanceof Fraction f) {
            Expression tmp = new Number(value).mul(f.getDenominator());
            return new Fraction ((f).getNumerator().add(tmp), (f).getDenominator());
        }
        return null;
    }

    @Override
    public Expression sub(Expression v) {
        if (v instanceof Number n) {
            return new Number(value - n.getValue());
        } else if (v instanceof Fraction f) {
            Expression tmp = new Number(value).mul(f.getDenominator());
            return new Fraction ((f).getNumerator().sub(tmp), (f).getDenominator());
        }
        return null;
    }

    @Override
    public Expression mul(Expression v) {
        if (v instanceof Number n) {
            return new Number(value * n.getValue());
        } else if (v instanceof Fraction f) {
            return new Fraction(f.getNumerator().mul(new Number(this.getValue())), f.getDenominator().mul(new Number(1)));
        }
        return null;
    }

    @Override
    public Expression div(Expression v) {
        if (v instanceof Number n) {
            if (value % n.getValue() == 0) {
                return new Number(value / n.getValue());
            } else {
                return new Fraction(new Number(value), new Number(n.getValue()));
            }
        } else if (v instanceof Fraction f) {
            Expression tmp = new Fraction(f.getDenominator(), f.getNumerator());
            return this.mul(tmp);
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
