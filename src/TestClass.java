import expressions.Number;
import latex.LatexParseManager;
import expressions.*;

import java.io.File;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
    static final LatexParseManager LPM = new LatexParseManager("src/tmp");

    public static void main(String[] args) {
        Number n1 = new Number(-5);
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 3);
        System.out.println(f1.add(f2));
        System.out.println(f1.add(n1));
        System.out.println(f1.div(f2));
        System.out.println(f1.div(n1));
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