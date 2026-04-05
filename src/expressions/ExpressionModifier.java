package expressions;

import expressions.settings.ExpressionSettings;
import expressions.settings.SettingsState;

public class ExpressionModifier implements Expression {
    private String prefix = "";
    private String suffix = "";
    private ExpressionSettings expressionSettings;

    @Override
    public String get() {
        return "";
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public boolean isPositive() {
        return false;
    }

    @Override
    public boolean isOne() {
        return false;
    }

    @Override
    public boolean isMinusOne() {
        return false;
    }

    @Override
    public Expression add(Expression expression) {
        return null;
    }

    @Override
    public Expression sub(Expression expression) {
        return null;
    }

    @Override
    public Expression mul(Expression expression) {
        return null;
    }

    @Override
    public Expression div(Expression expression) {
        return null;
    }

    @Override
    public Expression getGCD(Expression expression) {
        return null;
    }

    @Override
    public Expression optimize() {
        return this;
    }

    @Override
    public void checkIntegrity() {
    }

    @Override
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public String getSuffix() {
        return suffix;
    }

    @Override
    public Expression copy() {
        return null;
    }

    @Override
    public Expression setExpressionSettings(ExpressionSettings expressionSettings) {
        this.expressionSettings = expressionSettings;
        return this;
    }

    @Override
    public Expression setRenderLeadingPluses(boolean value) {
        if (this.expressionSettings == null) {
            this.expressionSettings = SettingsState.getExpressionSettings().copy();
        }
        this.expressionSettings.setRenderingLeadingPluses(value);
        return this;
    }

    @Override
    public Expression setRenderingOnes(boolean value) {
        if (this.expressionSettings == null) {
            this.expressionSettings = SettingsState.getExpressionSettings().copy();
        }
        this.expressionSettings.setRenderingOnes(value);
        return this;
    }

    @Override
    public Expression setAutomaticallyOptimizing(boolean value) {
        if (this.expressionSettings == null) {
            this.expressionSettings = SettingsState.getExpressionSettings().copy();
        }
        this.expressionSettings.setAutomaticallyOptimizing(value);
        return this;
    }

    @Override
    public Expression setAutomaticallyPassingSettingsToChildren(boolean value) {
        if (this.expressionSettings == null) {
            this.expressionSettings = SettingsState.getExpressionSettings().copy();
        }
        this.expressionSettings.setAutomaticallyPassingSettingsToChildren(value);
        return this;
    }

    protected ExpressionSettings getSettings() {
        if (expressionSettings == null) {
            return SettingsState.getExpressionSettings();
        }
        return expressionSettings;
    }
}
