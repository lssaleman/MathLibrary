package values;

public class Polynom extends ExpressionModifier implements Expression {

    private final Expression[] values;


    public Polynom(Expression[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Polynom: given array ist not allowed to be null");
        }
        this.values = values;
    }

    @Override
    public String get() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (i == values.length - 1) {
                sb.append("(").append(values[i].get()).append(")");
            } else if (i == values.length - 2) {
                sb.append("(").append(values[i].get()).append(")x + ");
            } else {
                sb.append(values[i].get()).append("x^(").append(values.length - 1 - i).append(") + ");
            }
        }
        return sb.toString();
    }

    @Override
    public boolean isZero() {
        for (Expression v : values) {
            if (!v.isZero()) {
                return false;
            }
        }
        return true;
    }

    /**
     * A Value is always defined as positive when it doesn't represent one
     * fixed number. So no matter what this will always return true
     * @return always true
     */
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


    public Expression[] getValues() {
        return values;
    }
}
