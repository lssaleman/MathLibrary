import latex.LatexParseManager;
import values.*;
import values.Number;

public class TestClass {
    static final LatexParseManager LPM = new LatexParseManager("src/tmp");

    public static void main(String[] args) {
        Number n1 = new Number(-4);
        Number n2 = new Number(-3);
        Number n3 = new Number(0);
        Fraction f1 = new Fraction(n1, n2);
        SquareRoot s1 = new SquareRoot(new Fraction(new Number(5), new Number(7)));

        Expression[] values = new Expression[] {n1, n2, f1, n3, s1};
        Polynom p = new Polynom(values);

        p.setPrefix("-((");
        p.setSuffix("))");
        LPM.parseIntoFile(p);
    }
}