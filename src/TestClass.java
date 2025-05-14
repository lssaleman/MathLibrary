import expressions.Number;
import latex.LatexParseManager;
import expressions.*;

import java.io.File;

import java.util.Scanner;

public class TestClass {
    static final LatexParseManager LPM = new LatexParseManager("src/tmp");

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Number n1 = new Number(-5);
        Value v1 = new Value(f1);
        System.out.println(LPM.parseString(v1));
        v1 = (Value) v1.add(n1);
        System.out.println(LPM.parseString(v1));
        v1 = (Value) v1.mul(n1);
        System.out.println(LPM.parseString(v1));
        v1 = (Value) v1.add(new SquareRoot(5));
        System.out.println(LPM.parseString(v1));
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