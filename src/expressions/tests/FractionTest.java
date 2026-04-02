package expressions.tests;

import expressions.Fraction;
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
        if (!fractionInit()) {
            String message = Notifications.FAILED + FRACTION_INIT + ": " + errorMessage;
            System.out.println(message);
            failedTests.add(message);
        } else {
            System.out.println(Notifications.PASSED + FRACTION_INIT);
        }
        if (!fractionTestSettings()) {
            String message = Notifications.WORK_IN_PROGRESS + FRACTION_SETTINGS + ": " + errorMessage;
            System.out.println(message);
            //failedTests.add(message);
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

    private static boolean fractionInit() {
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
        return true;
    }

    private static boolean fractionTestSettings() {
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
