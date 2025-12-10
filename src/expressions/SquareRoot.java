package expressions;

public class SquareRoot extends ExpressionModifier implements Expression {

    private final Expression value;
    private final Expression preFactor;

    public SquareRoot(Expression v) {
        this.value = v;
        this.preFactor = new Number(1);
    }

    public SquareRoot(int value) {
        this.value = new Number(value);
        this.preFactor = new Number(1);
    }

    public SquareRoot(Expression value, Expression preFactor) {
        this.value = value;
        this.preFactor = preFactor;
    }

    public SquareRoot(int value, int preFactor) {
        this.value = new Number(value);
        this.preFactor = new Number(preFactor);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SquareRoot s) {
            return this.value.equals(s.value) && this.preFactor.equals(s.preFactor);
        }
        return false;
    }

    @Override
    public String get() {
        return "sqrt(" + value.get() + ")";
    }

    @Override
    public boolean isZero() {
        return value.isZero() || preFactor.isZero();
    }

    @Override
    public boolean isPositive() {
        return preFactor.isPositive();
    }

    @Override
    public boolean isOne() {
        return this.preFactor.isOne() && this.value.isOne();
    }

    @Override
    public boolean isMinusOne() {
        return this.preFactor.isMinusOne() && this.value.isOne();
    }

    @Override
    public String toString() {
        String base = preFactor.isOne() ? "" : preFactor.isMinusOne() ? "-" : preFactor.toString();
        return base + "\\sqrt{" + value + "}";
    }

    @Override
    public Expression add(Expression expression) {
        return null;
    }

    @Override
    public Expression sub(Expression expression) {
        return null;
    }

    @Override
    public Expression mul(Expression expression) {
        if (expression instanceof SquareRoot s) {
            Expression newValue = s.value.mul(this.value);
            Expression newPreFactor = s.preFactor.mul(this.preFactor);
            return new SquareRoot(newValue, newPreFactor);
        }
        return new SquareRoot(preFactor.mul(expression), this.value);
    }

    @Override
    public Expression div(Expression expression) {
        if (expression instanceof SquareRoot s) {
            Expression newValue = s.value.div(this.value);
            Expression newPreFactor = s.preFactor.div(this.preFactor);
            return new SquareRoot(newValue, newPreFactor);
        }
        return new Fraction(this, expression);
    }

    public Expression getValue() {
        return value;
    }
}
