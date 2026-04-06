package expressions;

public class SquareRoot extends ExpressionModifier implements Expression {

    private final Expression value;
    private final Expression preFactor;

    public SquareRoot(Expression value) {
        this.value = value.copy().setRenderLeadingPluses(false).setRenderingOnes(true);
        this.preFactor = new Number(1).setRenderingOnes(false);
    }

    public SquareRoot(int value) {
        this.value = new Number(value).setRenderLeadingPluses(false).setRenderingOnes(true);
        this.preFactor = new Number(1).setRenderingOnes(false);
    }

    public SquareRoot(Expression value, Expression preFactor) {
        this.value = value.copy().setRenderLeadingPluses(false).setRenderingOnes(true);
        this.preFactor = preFactor.copy().setRenderingOnes(false);
    }

    public SquareRoot(int value, int preFactor) {
        this.value = new Number(value).setRenderLeadingPluses(false).setRenderingOnes(true);
        this.preFactor = new Number(preFactor).setRenderingOnes(false);
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
        return preFactor + "\\sqrt{" + value + "}";
    }

    @Override
    public Expression add(Expression expression) {
        if (expression instanceof SquareRoot squareRoot) {
            if (this.preFactor.equals(squareRoot.preFactor)) {
                return new SquareRoot(value, this.preFactor.add(squareRoot.preFactor));
            }
        }
        return new SumValue(this, expression);
    }

    @Override
    public Expression sub(Expression expression) {
        if (expression instanceof SquareRoot squareRoot) {
            if (this.preFactor.equals(squareRoot.preFactor)) {
                return new SquareRoot(value, this.preFactor.sub(squareRoot.preFactor));
            }
        }
        return new SumValue(this, expression);
    }

    @Override
    public Expression mul(Expression expression) {
        if (expression instanceof SquareRoot squareRoot) {
            Expression newValue = squareRoot.value.mul(this.value);
            Expression newPreFactor = squareRoot.preFactor.mul(this.preFactor);
            return new SquareRoot(newValue, newPreFactor);
        }
        return new SquareRoot(this.value, preFactor.mul(expression));
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

    @Override
    public Expression copy() {
        return new SquareRoot(this.value, this.preFactor);
    }

    public Expression getValue() {
        return value;
    }
}
