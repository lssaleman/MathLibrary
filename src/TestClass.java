import latex.LatexParseManager;
import expressions.*;

import java.io.File;
import java.util.Scanner;

public class TestClass {
    static final LatexParseManager LPM = new LatexParseManager("src/tmp");

    public static void main(String[] args) {
        Fraction f =  new Fraction(3, 4);
        Fraction n =  new Fraction(3, 5);
        Expression e = n.sub(f);
        LPM.parseIntoFile(e);
        readTMP();
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