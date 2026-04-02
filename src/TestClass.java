import expressions.Number;
import expressions.settings.ExpressionSettings;
import expressions.settings.SettingsState;
import latex.LatexParseManager;
import expressions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TestClass {
    static final LatexParseManager LPM = new LatexParseManager("src/tmp");

    public static void main(String[] args) {
        ExpressionSettings expressionSettings = new ExpressionSettings();
        expressionSettings
                .setAutomaticallyOptimizing(false)
                .setRenderingLeadingPluses(false);
        Number n1 = new Number(-1);
        Number n2 = new Number(1);
        Number n3 = new Number(20);
        Number n4 = new Number(-20);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3 + " " + n4);
        System.out.println(n4 + " " + n3);

        SettingsState.setExpressionSettings(new ExpressionSettings().setRenderingLeadingPluses(true));
        n3.setRenderLeadingPluses(false);
        System.out.println(n3 + " " + n4);
        n3.setRenderLeadingPluses(true);
        System.out.println(n4 + " " + n3);
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