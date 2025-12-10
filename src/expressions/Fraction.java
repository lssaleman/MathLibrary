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

    @Override
    public String toString() {
        if (numerator.isPositive()) {
            return "\\frac{" + numerator.toString() + "}{" + denominator.toString() + "}";
        }
        return "-\\frac{" + numerator.mul(new Number(-1)).toString() + "}{" + denominator.toString() + "}";
    }

    private void makeDenominatorPositive() {
        if (!denominator.isPositive()) {
            Number negation = new Number(-1);
            numerator = numerator.mul(negation);
            denominator = denominator.mul(negation);
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

    @Override
    public Expression add(Expression expression) {
        if (expression instanceof Fraction f) {
            Fraction tmp1 = new Fraction(f.numerator.mul(this.denominator), f.denominator.mul(this.denominator));
            Fraction tmp2 = new Fraction(this.numerator.mul(f.denominator), this.denominator.mul(f.denominator));
            return new Fraction(tmp1.numerator.add(tmp2.numerator), tmp1.denominator);
        }
        Fraction fraction = new Fraction(expression, new Number(1));
        fraction.numerator = fraction.numerator.mul(this.denominator);
        fraction.denominator = fraction.denominator.mul(this.denominator);
        return new Fraction(this.numerator.add(fraction.numerator).mul(new Number(1)), this.denominator);
    }

    @Override
    public Expression sub(Expression expression) {
        if (expression instanceof Fraction f) {
            Fraction tmp1 = new Fraction(f.numerator.mul(this.denominator), f.denominator.mul(this.denominator));
            Fraction tmp2 = new Fraction(this.numerator.mul(f.denominator), this.denominator.mul(f.denominator));
            return new Fraction(tmp1.numerator.sub(tmp2.numerator), tmp1.denominator);
        }
        Fraction fraction = new Fraction(expression, new Number(1));
        fraction.numerator = fraction.numerator.mul(this.denominator);
        fraction.denominator = fraction.denominator.mul(this.denominator);
        return new Fraction(this.numerator.sub(fraction.numerator).mul(new Number(1)), this.denominator);
    }

    @Override
    public Expression mul(Expression expression) {
        if (expression instanceof Fraction f) {
            return new Fraction(this.numerator.mul(f.numerator), this.denominator.mul(f.denominator));
        }
        return new Fraction(this.numerator.mul(expression), this.denominator);
    }

    @Override
    public Expression div(Expression expression) {
        if (expression instanceof Fraction f) {
            return this.mul(f.getReciprocal());
        }
        return new Fraction(this.numerator, this.denominator.mul(expression));
    }
}
