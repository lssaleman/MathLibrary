package values;

public class SquareRoot extends ExpressionModifier implements Expression {

    private final Expression value;

    public SquareRoot(Expression v) {
        this.value = v;
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
    public Expression add(Expression v) {
        return null;
    }

    @Override
    public Expression sub(Expression v) {
        return null;
    }

    @Override
    public Expression mul(Expression v) {
        return null;
    }

    @Override
    public Expression div(Expression v) {
        return null;
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
