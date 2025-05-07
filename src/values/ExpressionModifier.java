package values;

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
    public Expression add(Expression v) {
        return null;
    }

    @Override
    public Expression sub(Expression v) {
        return null;
    }

    @Override
    public Expression mul(Expression v) {
        return null;
    }

    @Override
    public Expression div(Expression v) {
        return null;
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
