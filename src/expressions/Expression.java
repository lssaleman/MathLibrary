package expressions;

public interface Expression {
    String get();

    boolean isZero();

    boolean isPositive();

    Expression add(Expression e);

    Expression sub(Expression e);

    Expression mul(Expression e);

    Expression div(Expression e);

    void optimize();

    void checkIntegrity();

    void setPrefix(String prefix);

    void setSuffix(String suffix);

    String getPrefix();

    String getSuffix();
    
}