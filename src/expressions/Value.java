package expressions;

import java.util.ArrayList;

public class Value extends ExpressionModifier implements Expression {
    ArrayList<Expression> values = new ArrayList<>();

    public Value(Expression v) {
        values.add(v);
    }

    public Value(ArrayList<Expression> values) {
        this.values = values;
    }

    @Override
    public String get() {
        StringBuilder sb = new StringBuilder();
        for (Expression expression: values) {
            sb.append(expression.get());
        }
        return sb.toString();
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

    public ArrayList<Expression> getValues() {
        return values;
    }
}
