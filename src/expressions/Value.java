package expressions;

import java.util.ArrayList;

public class Value extends ExpressionModifier implements Expression {
    ArrayList<Expression> values = new ArrayList<>();

    public Value(Value v) {
        values.add(v);
    }

    @Override
    public String get() {
        return "";
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public boolean isPositive() {
        return false;
    }

    @Override
    public void optimize() {

    }

    @Override
    public void checkIntegrity() {

    }
}
