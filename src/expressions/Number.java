package expressions;

public class Number extends ExpressionModifier {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public String get() {
        return String.valueOf(value);
    }

    @Override
    public boolean isZero() {
        return value == 0;
    }

    @Override
    public boolean isPositive() {
        return value >= 0;
    }

    public int getValue() {
        return value;
    }
}
