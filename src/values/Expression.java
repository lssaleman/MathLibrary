package values;

public interface Expression {
    public String get();

    public boolean isZero();

    public boolean isPositive();

    public Expression add(Expression v);

    public Expression sub(Expression v);

    public Expression mul(Expression v);

    public Expression div(Expression v);

    public void optimize();

    public void checkIntegrity();

    public void setPrefix(String prefix);

    public void setSuffix(String suffix);

    public String getPrefix();

    public String getSuffix();
    
}