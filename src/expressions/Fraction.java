package expressions;

import expressions.settings.ExpressionSettings;
import expressions.settings.SettingsState;

public class Fraction extends ExpressionModifier implements Expression {
    private Expression numerator;
    private Expression denominator;

    public Fraction(Expression numerator, Expression denominator) {
        this.numerator = numerator.copy();
        this.denominator = denominator.copy();
        applyFractionRules();
    }

    public Fraction(Expression numerator, int denominator) {
        this.numerator = numerator.copy();
        this.denominator = new Number(denominator);
        applyFractionRules();
    }

    public Fraction(int numerator, Expression denominator) {
        this.numerator = new Number(numerator);
        this.denominator = denominator.copy();
        applyFractionRules();
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = new Number(numerator);
        this.denominator = new Number(denominator);
        applyFractionRules();
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
        ExpressionSettings expressionSettings = getSettings();
        if (isPositive()) {
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
            return checkForOptimization(new Fraction(tmp1.numerator.add(tmp2.numerator), tmp1.denominator));
        }
        Fraction fraction = new Fraction(expression, new Number(1));
        fraction.numerator = fraction.numerator.mul(this.denominator);
        fraction.denominator = fraction.denominator.mul(this.denominator);
        return checkForOptimization(new Fraction(this.numerator.add(fraction.numerator).mul(new Number(1)), this.denominator));
    }

    @Override
    public Expression sub(Expression expression) {
        if (expression instanceof Fraction f) {
            Fraction tmp1 = new Fraction(this.numerator.mul(f.denominator), this.denominator.mul(f.denominator));
            Fraction tmp2 = new Fraction(f.numerator.mul(this.denominator), f.denominator.mul(this.denominator));
            return checkForOptimization(new Fraction(tmp1.numerator.sub(tmp2.numerator), tmp1.denominator));
        }
        Fraction fraction = new Fraction(expression, new Number(1));
        fraction.numerator = fraction.numerator.mul(this.denominator);
        fraction.denominator = fraction.denominator.mul(this.denominator);
        return checkForOptimization(new Fraction(this.numerator.sub(fraction.numerator).mul(new Number(1)), this.denominator));
    }

    @Override
    public Expression mul(Expression expression) {
        if (expression instanceof Fraction f) {
            return checkForOptimization(new Fraction(this.numerator.mul(f.numerator), this.denominator.mul(f.denominator)));
        }
        return checkForOptimization(new Fraction(this.numerator.mul(expression), this.denominator));
    }

    @Override
    public Expression div(Expression expression) {
        if (expression instanceof Fraction f) {
            return checkForOptimization(this.mul(f.getReciprocal()));
        }
        return checkForOptimization(new Fraction(this.numerator, this.denominator.mul(expression)));
    }

    @Override
    public Expression optimize() {
        if (denominator.isOne()) {
            return numerator;
        }
        if (denominator.mul(new Number(-1)).isOne()) {
            return denominator.mul(new Number(-1));
        }
        if (this.numerator.equals(this.denominator)) {
            return new Number(1);
        }
        if (this.numerator.mul(new Number(-1)).equals(this.denominator)) {
            return new Number(-1);
        }

        if (denominator instanceof Fraction fraction) {
            return numerator.mul(fraction.getReciprocal());
        }

        Expression gcd = this.numerator.getGCD(this.denominator);
        return new Fraction(this.numerator.div(gcd), this.denominator.div(gcd));
    }

    @Override
    public Expression copy() {
        return new Fraction(this.numerator.copy(), this.denominator.copy());
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

    private void applyFractionRules() {
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

    private Expression checkForOptimization(Expression expression) {
        if (getSettings().isAutomaticallyOptimizing()) {
            return expression.optimize();
        }
        return expression;
    }
}
