package expressions;

import expressions.settings.ExpressionSettings;

public interface Expression {
    String get();

    boolean isZero();

    boolean isPositive();

    boolean isOne();

    boolean isMinusOne();

    Expression add(Expression expression);

    Expression sub(Expression expression);

    Expression mul(Expression expression);

    Expression div(Expression expression);

    Expression getGCD(Expression expression);

    Expression optimize();

    void checkIntegrity();

    void setPrefix(String prefix);

    void setSuffix(String suffix);

    String getPrefix();

    String getSuffix();

    Expression copy();

    public Expression setExpressionSettings(ExpressionSettings expressionSettings);

    public Expression setRenderLeadingPluses(boolean value);

    public Expression setRenderingOnes(boolean value);

    public Expression setAutomaticallyOptimizing(boolean value);

    public Expression setAutomaticallyPassingSettingsToChildren(boolean value);
}