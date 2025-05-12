package expressions;

public class Fraction extends ExpressionModifier implements Expression {
    private Expression numerator;
    private Expression denominator;

    public Fraction(Expression numerator, Expression denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        makeDenominatorPositive();
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = new Number(numerator);
        this.denominator = new Number(denominator);
        makeDenominatorPositive();
    }

    @Override
    public String get() {
        return "(" + numerator.get() + ")/(" + denominator.get() + ")";
    }

    @Override
    public boolean isZero() {
        return getNumerator().isZero();
    }

    @Override
    public boolean isPositive() {
        return numerator.isPositive();
    }


    @Override
    public void optimize() {

    }

    @Override
    public void checkIntegrity() {

    }

    private void makeDenominatorPositive() {
        if (!denominator.isPositive()) {
            Number tmp = new Number(-1);
            numerator = numerator.mul(tmp);
            denominator = denominator.mul(tmp);
        }
    }

    public Expression getNumerator()  {
        return numerator;
    }

    public Expression getDenominator() {
        return denominator;
    }

    public Fraction getReciprocal() {
        return new Fraction(this.getDenominator(), this.getNumerator());
    }

}
