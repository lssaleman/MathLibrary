import expressions.Number;
import latex.LatexParseManager;
import expressions.*;

import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
    static final LatexParseManager LPM = new LatexParseManager("src/tmp");

    public static void main(String[] args) {
        Number n1 = new Number(-1);
        Number n2 = new Number(2);
        Fraction f1 = new Fraction(n1, n2);
        SquareRoot s1 = new SquareRoot(f1);
        System.out.println(f1);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(s1);
        ArrayList<Expression> values = new ArrayList<>();
        values.add(n1);
        values.add(n2);
        values.add(f1);
        values.add(s1);
        Value v1 = new Value(values);
        System.out.println(v1);
    }


    public static void readTMP() {
        File f = new File("src/tmp");
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                System.out.println(s.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Problem beim Datei Lesen.");
        }
    }
}