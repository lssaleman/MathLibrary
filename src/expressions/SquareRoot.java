package expressions;

public class SquareRoot extends ExpressionModifier implements Expression {

    private final Expression value;

    public SquareRoot(Expression v) {
        this.value = v;
    }

    public SquareRoot(int value) {
        this.value = new Number(value);
    }

    @Override
    public String get() {
        return "sqrt(" + value.get() + ")";
    }

    @Override
    public boolean isZero() {
        return value.isZero();
    }

    @Override
    public boolean isPositive() {
        return true;
    }


    @Override
    public void optimize() {

    }

    @Override
    public void checkIntegrity() {

    }


    public Expression getValue() {
        return value;
    }
}
