package expressions;

import math.calculators.Control;

public class ExpressionModifier implements Expression{
    private String prefix = "";
    private String suffix = "";

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
    public Expression add(Expression e) {
        return Control.add(this, e);
    }

    @Override
    public Expression sub(Expression e) {
        return Control.sub(this, e);
    }


    @Override
    public Expression mul(Expression e) {
        return Control.mul(this, e);
    }

    @Override
    public Expression div(Expression e) {
        return Control.div(this, e);
    }

    @Override
    public void optimize() {

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
}
