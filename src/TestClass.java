import expressions.Number;
import latex.LatexParseManager;
import expressions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TestClass {
    static final LatexParseManager LPM = new LatexParseManager("src/tmp");

    public static void main(String[] args) {
        Number n1 = new Number(-1);
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(-2, -2);
        SquareRoot s1 = new SquareRoot(f1, n1);
        System.out.println(s1);
        System.out.println(f2);
        System.out.println(s1.sub(s1));
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

    public static void writeTMP(Expression expression) {
        String errorMessage = "Failed saving: ";

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/tmp"))) {
            bufferedWriter.append(expression.toString());
        } catch (Exception e) {
            System.out.println(errorMessage + "src/tmp" + " " + e.getMessage());
        }
    }
}