package latex;

import expressions.*;
import expressions.Number;

import java.io.File;
import java.io.PrintStream;

public class LatexParseManager {
    File file;
    PrintStream output;

    public LatexParseManager(String path) {
        try {
            file = new File(path);
            output = new PrintStream(file);
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public void parseIntoFile(Expression expression) {
        output.print(rekursiveGeneration(expression));
    }

    public String praseString(Expression expression) {
        return rekursiveGeneration(expression);
    }

    private String rekursiveGeneration(Expression value) {
        String result = "Kein Passender Typ gefunden";

        if (value instanceof Number n) {
            result = LatexParser.parseNumber(n.get(), n.getPrefix(), n.getSuffix());

        } else if (value instanceof Fraction f) {
            boolean isPositive = true;
            if (!f.isPositive()) {
                f = (Fraction) f.mul(new Number(-1));
                isPositive = false;
            }
            result = LatexParser.parseFraction(rekursiveGeneration(f.getNumerator()), rekursiveGeneration(f.getDenominator()), isPositive, f.getPrefix(), f.getSuffix());

        } else if (value instanceof SquareRoot s) {
            result = LatexParser.parseSquareRoot(rekursiveGeneration(s.getValue()), s.getPrefix(), s.getSuffix());

        } else if (value instanceof Polynom p) {
            Expression[] values = p.getValues();
            String[] polynomValues = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                if (values[i].isZero()) {
                    continue;
                }
                polynomValues[i] = rekursiveGeneration(values[i]);
            }
            result = LatexParser.parsePolynom(polynomValues, p.getPrefix(), p.getSuffix());
        }
        return result;
    }
}
