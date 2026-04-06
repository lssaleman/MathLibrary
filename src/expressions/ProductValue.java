package expressions;

public class ProductValue extends ExpressionModifier implements Expression {
    Expression expression1;
    Expression expression2;

    public ProductValue(Expression expression1, Expression expression2) {
        this.expression1 = expression1.copy().setRenderingOnes(true).setRenderLeadingPluses(false);
        this.expression2 = expression2.copy().setRenderingOnes(true).setRenderLeadingPluses(false);
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public boolean isZero() {
        return expression1.isZero() && expression2.isZero();
    }

    @Override
    public boolean isPositive() {
        return expression1.isPositive();
    }

    @Override
    public void checkIntegrity() {
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        if (getSettings().isRenderingLeadingPluses() && isPositive()) {
            string.append("+");
        }
        string.append(expression1).append(" * ");
        if (!expression2.isPositive()) {
            string.append("(").append(expression2).append(")");
        } else {
            string.append(expression2);
        }
        return string.toString();
    }

    @Override
    public Expression add(Expression expression) {
        return new SumValue(this, expression);
    }

    @Override
    public Expression sub(Expression expression) {
        return new SumValue(this, expression.mul(new Number(-1)));
    }

    @Override
    public Expression mul(Expression expression) {
        return new ProductValue(expression1, expression2.mul(expression));
    }

    @Override
    public Expression div(Expression expression) {
        return new ProductValue(expression1, expression2.div(expression));
    }

    @Override
    public Expression optimize() {
        return new ProductValue(expression1.optimize(), expression2.optimize());
    }

    @Override
    public Expression copy() {
        return new ProductValue(this.expression1.copy(), this.expression2.copy());
    }
}
