package expressions.tests;

import expressions.Expression;
import expressions.Fraction;
import expressions.Number;
import expressions.settings.ExpressionSettings;
import expressions.settings.SettingsState;
import util.Notifications;

import java.util.ArrayList;

public class FractionTest {
    private static String errorMessage;

    private static final String FRACTION_INIT = "FRACTION_INIT";
    private static final String FRACTION_SETTINGS = "FRACTION_SETTINGS";
    private static final String FRACTION_ADDITION_FRACTION = "FRACTION_ADDITION_FRACTION";
    private static final String FRACTION_SUBTRACTION_FRACTION = "FRACTION_SUBTRACTION_FRACTION";
    private static final String FRACTION_MULTIPLICATION_FRACTION = "FRACTION_MULTIPLICATION_FRACTION";
    private static final String FRACTION_DIVISION_FRACTION = "FRACTION_DIVISION_FRACTION";
    private static final String FRACTION_OPTIMIZES_TO_NUMBER = "FRACTION_OPTIMIZES_TO_NUMBER";

    public static void startFractionTests(ArrayList<String> failedTests) {
        if (!fractionInitTest()) {
            String message = Notifications.FAILED + FRACTION_INIT + ": " + errorMessage;
            System.out.println(message);
            failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_INIT);
        }
        if (!fractionSettingsTest()) {
            String message = Notifications.FAILED + FRACTION_SETTINGS + ": " + errorMessage;
            System.out.println(message);
            failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_SETTINGS);
        }
        if (!fractionAdditionFraction()) {
            String message = Notifications.FAILED + FRACTION_ADDITION_FRACTION + ": " + errorMessage;
            System.out.println(message);
            failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_ADDITION_FRACTION);
        }
        if (!fractionSubtractionFraction()) {
            String message = Notifications.FAILED + FRACTION_SUBTRACTION_FRACTION + ": " + errorMessage;
            System.out.println(message);
            failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_SUBTRACTION_FRACTION);
        }
        if (!fractionMultiplicationFraction()) {
            String message = Notifications.FAILED + FRACTION_MULTIPLICATION_FRACTION + ": " + errorMessage;
            System.out.println(message);
            failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_MULTIPLICATION_FRACTION);
        }
        if (!fractionDivisionFraction()) {
            String message = Notifications.FAILED + FRACTION_DIVISION_FRACTION + ": " + errorMessage;
            System.out.println(message);
            failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_DIVISION_FRACTION);
        }

        if (!fractionOptimizesToNumber()) {
            String message = Notifications.FAILED + FRACTION_OPTIMIZES_TO_NUMBER + ": " + errorMessage;
            System.out.println(message);
            failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_OPTIMIZES_TO_NUMBER);
        }
    }

    private static boolean fractionInitTest() {
        Fraction fraction;
        String expected;

        fraction = new Fraction(1, 2);
        expected = "\\frac{1}{2}";
        if (!fraction.toString().equals(expected)) {
            errorMessage = "Fraction should " + expected + ". Observed " + fraction;
            return false;
        }

        fraction = new Fraction(-1, 2);
        expected = "-\\frac{1}{2}";
        if (!fraction.toString().equals(expected)) {
            errorMessage = "Fraction should " + expected + ". Observed " + fraction;
            return false;
        }

        fraction = new Fraction(-1, -2);
        expected = "\\frac{1}{2}";
        if (!fraction.toString().equals(expected)) {
            errorMessage = "Fraction should " + expected + ". Observed " + fraction;
            return false;
        }

        fraction = new Fraction(1, -2);
        expected = "-\\frac{1}{2}";
        if (!fraction.toString().equals(expected)) {
            errorMessage = "Fraction should " + expected + ". Observed " + fraction;
            return false;
        }

        fraction = new Fraction(1, -2);
        expected = "(-1)/(2)";
        if (!fraction.get().equals(expected)) {
            errorMessage = "Fraction values should be " + expected + ". Observed " + fraction.get();
            return false;
        }

        fraction = new Fraction(-1, 2);
        expected = "(-1)/(2)";
        if (!fraction.get().equals(expected)) {
            errorMessage = "Fraction values should be " + expected + ". Observed " + fraction.get();
            return false;
        }
        return true;
    }


    private static boolean fractionSettingsTest() {
        ExpressionSettings expressionSettings;
        Fraction fraction;

        expressionSettings = new ExpressionSettings().setRenderingOnes(true).setRenderingLeadingPluses(false);
        fraction = (Fraction) new Fraction(-1, 2).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "-\\frac{1}{2}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(false).setRenderingLeadingPluses(true);
        fraction = (Fraction) new Fraction(-1, 2).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "-\\frac{1}{2}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(true).setRenderingLeadingPluses(true);
        fraction = (Fraction) new Fraction(-1, 2).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "-\\frac{1}{2}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(false).setRenderingLeadingPluses(false);
        fraction = (Fraction) new Fraction(-1, 2).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "-\\frac{1}{2}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(true).setRenderingLeadingPluses(false);
        fraction = (Fraction) new Fraction(1, 2).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "\\frac{1}{2}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(false).setRenderingLeadingPluses(true);
        fraction = (Fraction) new Fraction(1, 2).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "+\\frac{1}{2}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(true).setRenderingLeadingPluses(true);
        fraction = (Fraction) new Fraction(1, 2).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "+\\frac{1}{2}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(false).setRenderingLeadingPluses(false);
        fraction = (Fraction) new Fraction(1, 2).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "\\frac{1}{2}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(true).setRenderingLeadingPluses(false);
        fraction = (Fraction) new Fraction(1, 1).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "\\frac{1}{1}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(false).setRenderingLeadingPluses(true);
        fraction = (Fraction) new Fraction(1, 1).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "+")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(true).setRenderingLeadingPluses(true);
        fraction = (Fraction) new Fraction(1, 1).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "+\\frac{1}{1}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(false).setRenderingLeadingPluses(false);
        fraction = (Fraction) new Fraction(1, 1).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(true).setRenderingLeadingPluses(false);
        fraction = (Fraction) new Fraction(-1, 1).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "-\\frac{1}{1}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(false).setRenderingLeadingPluses(true);
        fraction = (Fraction) new Fraction(-1, 1).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "-")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(true).setRenderingLeadingPluses(true);
        fraction = (Fraction) new Fraction(-1, 1).setExpressionSettings(expressionSettings);
        if (fractionSettingsTestHelperFailed(fraction, "-\\frac{1}{1}")) {
            return false;
        }

        expressionSettings = new ExpressionSettings().setRenderingOnes(false).setRenderingLeadingPluses(false);
        fraction = (Fraction) new Fraction(-1, 1).setExpressionSettings(expressionSettings);
        return !fractionSettingsTestHelperFailed(fraction, "-");
    }

    private static boolean fractionSettingsTestHelperFailed(Fraction fraction, String expected) {
        if (!fraction.toString().equals(expected)) {
            errorMessage = "Fraction should render " + expected + ". Observed " + fraction;
            return true;
        }
        return false;
    }

    private static boolean fractionAdditionFraction() {
        Expression result;
        String expected;
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(7, 10);

        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(false);
        result = f1.add(f2);
        expected = "\\frac{65}{50}";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of addition (3/5) + (7/10) without optimization should be " + expected + ". Observed " + result;
            return false;
        }

        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(true);
        result = f1.add(f2);
        expected = "\\frac{13}{10}";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of addition (3/5) + (7/10) with optimization should be " + expected + ". Observed " + result;
            return false;
        }
        return true;
    }

    private static boolean fractionSubtractionFraction() {
        Expression result;
        String expected;
        Fraction f1 = new Fraction(3, 5);
        Fraction f2 = new Fraction(7, 10);

        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(false);
        result = f1.sub(f2);
        expected = "-\\frac{5}{50}";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of subtraction (3/5) - (7/10) without optimization should be " + expected + ". Observed " + result;
            return false;
        }
        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(true);
        result = f1.sub(f2);
        expected = "-\\frac{1}{10}";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of subtraction (3/5) - (7/10) with optimization should be " + expected + ". Observed " + result;
            return false;
        }
        return true;
    }

    private static boolean fractionMultiplicationFraction() {
        Expression result;
        String expected;
        Fraction f1 = new Fraction(5, 3);
        Fraction f2 = new Fraction(7, 10);

        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(false);
        result = f1.mul(f2);
        expected = "\\frac{35}{30}";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of multiplication (5/3) * (7/10) without optimization should be " + expected + ". Observed " + result;
            return false;
        }
        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(true);
        result = f1.mul(f2);
        expected = "\\frac{7}{6}";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of multiplication (5/3) * (7/10) with optimization should be " + expected + ". Observed " + result;
            return false;
        }
        return true;
    }

    private static boolean fractionDivisionFraction() {
        Expression result;
        String expected;
        Fraction f1 = new Fraction(-5, 3);
        Fraction f2 = new Fraction(10, 7);

        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(false);
        result = f1.div(f2);
        expected = "-\\frac{35}{30}";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of division (5/3) / (10/7) without optimization should be " + expected + ". Observed " + result;
            return false;
        }
        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(true);
        result = f1.div(f2);
        expected = "-\\frac{7}{6}";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of division (-5/3) / (10/7) with optimization should be " + expected + ". Observed " + result;
            return false;
        }
        return true;
    }

    private static boolean fractionOptimizesToNumber() {
        Expression result;
        String expected;
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(1, 3);

        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(false);
        result = f1.add(f2);
        expected = "\\frac{9}{9}";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of addition (2/3) + (1/3) without optimization should be " + expected + ". Observed " + result;
            return false;
        }

        SettingsState.getExpressionSettings().setAutomaticallyOptimizing(true);
        result = f1.add(f2);
        expected = "1";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of addition (2/3) + (1/3) with optimization should be " + expected + ". Observed " + result;
            return false;
        }

        f1 = new Fraction(-4, 3);
        f2 = new Fraction(1, 3);
        result = f1.add(f2);
        expected = "-1";
        if (!result.toString().equals(expected)) {
            errorMessage = "Fraction result of addition (2/3) + (1/3) with optimization should be " + expected + ". Observed " + result;
            return false;
        }
        return true;
    }
}
