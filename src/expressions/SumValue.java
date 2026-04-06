package expressions;


public class SumValue extends ExpressionModifier implements Expression {
    Expression expression1;
    Expression expression2;

    public SumValue(Expression expression1, Expression expression2) {
        this.expression1 = expression1.copy().setRenderingOnes(true);
        this.expression2 = expression2.copy().setRenderingOnes(true).setRenderLeadingPluses(true);
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
        return expression1 + " " + expression2;
    }

    @Override
    public Expression add(Expression expression) {
        return new SumValue(expression1, expression2.add(expression));
    }

    @Override
    public Expression sub(Expression expression) {
        return new SumValue(expression1, expression2.sub(expression));
    }

    @Override
    public Expression mul(Expression expression) {
        return new SumValue(expression1.mul(expression), expression2.mul(expression));
    }

    @Override
    public Expression div(Expression expression) {
        return new Fraction(this, expression);
    }

    @Override
    public Expression optimize() {
        return new SumValue(expression1.optimize(), expression2.optimize());
    }

    @Override
    public Expression copy() {
        return new SumValue(this.expression1.copy(), this.expression2.copy());
    }
}
