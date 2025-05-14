package math.calculators;

import expressions.Expression;
import expressions.Number;
import expressions.Value;

import java.util.ArrayList;

public class ValueCalculator {
    public static Value valueAdd(Value value, Expression expression) {
        ArrayList<Expression> newValues = new ArrayList<>(value.getValues());
        newValues.add(expression);
        return new Value(newValues);
    }

    public static Value valueSub(Value value, Expression expression) {
        expression = expression.mul(new Number(-1));
        return valueAdd(value, expression);
    }

    public static Value valueMul(Value value, Expression expression) {
        ArrayList<Expression> newValues = new ArrayList<>();
        for (int i = 0; i < value.getValues().size(); i++) {
            Expression tmp = value.getValues().get(i).mul(expression);
            newValues.add(tmp);
        }
        return new Value(newValues);
    }

    public static Value valueDiv(Value value, Expression expression) {
        ArrayList<Expression> newValues = new ArrayList<>();
        for (int i = 0; i < value.getValues().size(); i++) {
            Expression tmp = value.getValues().get(i).div(expression);
            newValues.add(tmp);
        }
        return new Value(newValues);
    }
}
