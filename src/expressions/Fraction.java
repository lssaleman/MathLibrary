package expressions;

import expressions.settings.ExpressionSettings;
import expressions.settings.SettingsState;

public class Fraction extends ExpressionModifier implements Expression {
    private Expression numerator;
    private Expression denominator;

    public Fraction(Expression numerator, Expression denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        setUpFraction();
    }

    public Fraction(Expression numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = new Number(denominator);
        setUpFraction();
    }

    public Fraction(int numerator, Expression denominator) {
        this.numerator = new Number(numerator);
        this.denominator = denominator;
        setUpFraction();
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = new Number(numerator);
        this.denominator = new Number(denominator);
        setUpFraction();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fraction f) {
            return this.numerator.equals(f.numerator) && this.denominator.equals(f.denominator);
        }
        return false;
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
    public boolean isOne() {
        return this.numerator.equals(this.denominator);
    }

    @Override
    public boolean isMinusOne() {
        return this.numerator.mul(new Number(-1)).equals(this.denominator);
    }

    @Override
    public String toString() {
        StringBuilder fraction = new StringBuilder();
        ExpressionSettings expressionSettings = SettingsState.getExpressionSettings();

        if (numerator.isPositive()) {
            if (expressionSettings.isRenderingLeadingPluses()) {
                fraction.append("+");
            }

            if (!expressionSettings.isRenderingOnes() && this.numerator.equals(this.denominator)) {
                return fraction.toString();
            }

            fraction.append("\\frac{")
                    .append(numerator)
                    .append("}{")
                    .append(denominator)
                    .append("}");
            return fraction.toString();
        }

        fraction.append("-");
        if (!expressionSettings.isRenderingOnes() && this.numerator.mul(new Number(-1)).equals(this.denominator)) {
            return fraction.toString();
        }

        Expression tmp = overrideSettingsOfValue(numerator.mul(new Number(-1)));
        fraction.append("\\frac{")
                .append(tmp)
                .append("}{")
                .append(denominator)
                .append("}");
        return fraction.toString();
    }

    @Override
    public Expression add(Expression expression) {
        if (expression instanceof Fraction f) {
            Fraction tmp1 = new Fraction(f.numerator.mul(this.denominator), f.denominator.mul(this.denominator));
            Fraction tmp2 = new Fraction(this.numerator.mul(f.denominator), this.denominator.mul(f.denominator));
            return new Fraction(tmp1.numerator.add(tmp2.numerator), tmp1.denominator).optimize();
        }
        Fraction fraction = new Fraction(expression, new Number(1));
        fraction.numerator = fraction.numerator.mul(this.denominator);
        fraction.denominator = fraction.denominator.mul(this.denominator);
        return new Fraction(this.numerator.add(fraction.numerator).mul(new Number(1)), this.denominator).optimize();
    }

    @Override
    public Expression sub(Expression expression) {
        if (expression instanceof Fraction f) {
            Fraction tmp1 = new Fraction(f.numerator.mul(this.denominator), f.denominator.mul(this.denominator));
            Fraction tmp2 = new Fraction(this.numerator.mul(f.denominator), this.denominator.mul(f.denominator));
            return new Fraction(tmp1.numerator.sub(tmp2.numerator), tmp1.denominator).optimize();
        }
        Fraction fraction = new Fraction(expression, new Number(1));
        fraction.numerator = fraction.numerator.mul(this.denominator);
        fraction.denominator = fraction.denominator.mul(this.denominator);
        return new Fraction(this.numerator.sub(fraction.numerator).mul(new Number(1)), this.denominator).optimize();
    }

    @Override
    public Expression mul(Expression expression) {
        if (expression instanceof Fraction f) {
            return new Fraction(this.numerator.mul(f.numerator), this.denominator.mul(f.denominator)).optimize();
        }
        return new Fraction(this.numerator.mul(expression), this.denominator).optimize();
    }

    @Override
    public Expression div(Expression expression) {
        if (expression instanceof Fraction f) {
            return this.mul(f.getReciprocal()).optimize();
        }
        return new Fraction(this.numerator, this.denominator.mul(expression)).optimize();
    }

    @Override
    public Expression optimize() {
        if (this.numerator.equals(this.denominator)) {
            return new Number(1);
        }
        return this;
    }

    public Expression getNumerator() {
        return numerator;
    }

    public Expression getDenominator() {
        return denominator;
    }

    public Fraction getReciprocal() {
        return new Fraction(this.getDenominator(), this.getNumerator());
    }

    private void setUpFraction() {
        makeDenominatorPositive();
        overrideSettingsOfValue(numerator);
        overrideSettingsOfValue(denominator);
    }

    private void makeDenominatorPositive() {
        if (!denominator.isPositive()) {
            Number negation = new Number(-1);
            numerator = numerator.mul(negation);
            denominator = denominator.mul(negation);
        }
    }

    private Expression overrideSettingsOfValue(Expression expression) {
        ExpressionSettings expressionSettings = SettingsState.getExpressionSettings().copy()
                .setRenderingLeadingPluses(false)
                .setRenderingOnes(true);
        expression.setExpressionSettings(expressionSettings);
        return expression;
    }
}
