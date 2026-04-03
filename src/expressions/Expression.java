package expressions;

import expressions.settings.ExpressionSettings;
import expressions.settings.SettingsState;

public interface Expression {
    String get();

    boolean isZero();

    boolean isPositive();

    boolean isOne();

    boolean isMinusOne();

    Expression add(Expression e);

    Expression sub(Expression e);

    Expression mul(Expression e);

    Expression div(Expression e);

    Expression optimize();

    void checkIntegrity();

    void setPrefix(String prefix);

    void setSuffix(String suffix);

    String getPrefix();

    String getSuffix();

    Expression copy();

    public void setExpressionSettings(ExpressionSettings expressionSettings);

    public Expression setRenderLeadingPluses(boolean value);

    public Expression setRenderingOnes(boolean value);

    public Expression setAutomaticallyOptimizing(boolean value);

    public Expression setAutomaticallyPassingSettingsToChildren(boolean value);
}