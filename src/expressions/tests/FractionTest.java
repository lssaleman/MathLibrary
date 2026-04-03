package expressions.tests;

import expressions.Fraction;
import expressions.settings.ExpressionSettings;
import util.Notifications;

import java.util.ArrayList;

public class FractionTest {
    private static final int GENERAL_TEST_AMOUNT = 1000;
    private static String errorMessage;

    private static final String FRACTION_INIT = "FRACTION_INIT";
    private static final String FRACTION_SETTINGS = "FRACTION_SETTINGS";
    private static final String FRACTION_ADDITION_FRACTION = "FRACTION_ADDITION_FRACTION";
    private static final String FRACTION_SUBTRACTION_FRACTION = "FRACTION_SUBTRACTION_FRACTION";
    private static final String FRACTION_MULTIPLICATION_FRACTION = "FRACTION_MULTIPLICATION_FRACTION";
    private static final String FRACTION_DIVISION_FRACTION = "FRACTION_DIVISION_FRACTION";

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
            String message = Notifications.WORK_IN_PROGRESS + FRACTION_ADDITION_FRACTION + ": " + errorMessage;
            System.out.println(message);
            //failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_ADDITION_FRACTION);
        }
        if (!fractionSubtractionFraction()) {
            String message = Notifications.WORK_IN_PROGRESS + FRACTION_SUBTRACTION_FRACTION + ": " + errorMessage;
            System.out.println(message);
            //failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_SUBTRACTION_FRACTION);
        }
        if (!fractionMultiplicationFraction()) {
            String message = Notifications.WORK_IN_PROGRESS + FRACTION_MULTIPLICATION_FRACTION + ": " + errorMessage;
            System.out.println(message);
            //failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_MULTIPLICATION_FRACTION);
        }
        if (!fractionDivisionFraction()) {
            String message = Notifications.WORK_IN_PROGRESS + FRACTION_DIVISION_FRACTION + ": " + errorMessage;
            System.out.println(message);
            //failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_DIVISION_FRACTION);
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
        if(!fraction.toString().equals(expected)) {
            errorMessage = "Fraction should render " + expected + ". Observed " + fraction;
            return true;
        }
        return false;
    }

    private static boolean fractionAdditionFraction() {
        return false;
    }

    private static boolean fractionSubtractionFraction() {
        return false;
    }

    private static boolean fractionMultiplicationFraction() {
        return false;
    }

    private static boolean fractionDivisionFraction() {
        return false;
    }
}
