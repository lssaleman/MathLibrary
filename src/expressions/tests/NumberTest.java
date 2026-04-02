package expressions.tests;

import expressions.Expression;
import expressions.Fraction;
import expressions.Number;
import expressions.settings.ExpressionSettings;
import util.Notifications;

import java.util.Random;

public class NumberTest {
    private static final int GENERAL_TEST_AMOUNT = 1000;
    private static String errorMessage = "";

    private static final String NUMBER_INIT = "NUMBER_INIT";
    private static final String NUMBER_SETTINGS = "NUMBER_SETTINGS";
    private static final String NUMBER_ADDITION_NUMBER = "NUMBER_ADDITION_NUMBER";
    private static final String NUMBER_SUBTRACTION_NUMBER = "NUMBER_SUBTRACTION_NUMBER";
    private static final String NUMBER_MULTIPLICATION_NUMBER = "NUMBER_MULTIPLICATION_NUMBER";
    private static final String NUMBER_DIVISION_NUMBER = "NUMBER_DIVISION_NUMBER";


    public static void main(String[] args) {
        startNumberTesting();
    }

    public static void startNumberTesting() {
        if (!numberInit()) {
            System.out.print(Notifications.FAILED + NUMBER_INIT + ": ");
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_INIT);
        }
        if (!settingsTestNumber()) {
            System.out.print(Notifications.FAILED + NUMBER_SETTINGS + ": ");
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_SETTINGS);
        }
        if (!numberAdditionNumber()) {
            System.out.print(Notifications.FAILED + NUMBER_ADDITION_NUMBER + ": ");
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_ADDITION_NUMBER);
        }
        if (!numberSubtractionNumber()) {
            System.out.print(Notifications.FAILED + NUMBER_SUBTRACTION_NUMBER + ": ");
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_SUBTRACTION_NUMBER);
        }
        if (!numberMultiplicationNumber()) {
            System.out.print(Notifications.FAILED + NUMBER_MULTIPLICATION_NUMBER + ": ");
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_MULTIPLICATION_NUMBER);
        }
        if (!numberDivisionNumber()) {
            System.out.print(Notifications.FAILED + NUMBER_DIVISION_NUMBER + ": ");
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_DIVISION_NUMBER);
        }
    }

    public static boolean numberInit() {
        if (!numberInitHelp(0)) {
            return false;
        }
        if (!numberInitHelp(-100)) {
            return false;
        }
        if (!numberInitHelp(478)) {
            return false;
        }
        int limit = 1000;
        return numberInitHelp(new Random().nextInt(limit * -1, limit + 1));
    }

    public static boolean numberInitHelp(int testValue) {
        Number number = new Number(testValue);
        if (number.getValue() != testValue) {
            errorMessage = "Value should be " + testValue + ". Observed " + number.getValue();
            return false;
        }
        return true;
    }

    public static boolean settingsTestNumber() {
        String firstHalf = "String value of number should equal \"";
        String secondHalf = "\". Observed ";

        ExpressionSettings expressionSettings;
        Number number;

        number = new Number(5);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(true).setRenderingOnes(false);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals("+" + number.getValue())) {
            errorMessage = firstHalf + "+" + number.getValue() + secondHalf + number;
            return false;
        }

        number = new Number(5);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(false).setRenderingOnes(true);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals(String.valueOf(number.getValue()))) {
            errorMessage = firstHalf + number.getValue() + secondHalf + number;
            return false;
        }

        number = new Number(5);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(true).setRenderingOnes(true);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals("+" + number.getValue())) {
            errorMessage = firstHalf + "+" + number.getValue() + secondHalf + number;
            return false;
        }

        number = new Number(5);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(false).setRenderingOnes(false);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals(String.valueOf(number.getValue()))) {
            errorMessage = firstHalf + number.getValue() + secondHalf + number;
            return false;
        }

        number = new Number(-5);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(true).setRenderingOnes(false);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals(String.valueOf(number.getValue()))) {
            errorMessage = firstHalf + number.getValue() + secondHalf + number;
            return false;
        }

        number = new Number(-5);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(false).setRenderingOnes(true);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals(String.valueOf(number.getValue()))) {
            errorMessage = firstHalf + number.getValue() + secondHalf + number;
            return false;
        }

        number = new Number(-5);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(true).setRenderingOnes(true);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals(String.valueOf(number.getValue()))) {
            errorMessage = firstHalf + number.getValue() + secondHalf + number;
            return false;
        }

        number = new Number(-5);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(false).setRenderingOnes(false);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals(String.valueOf(number.getValue()))) {
            errorMessage = firstHalf + number.getValue() + secondHalf + number;
            return false;
        }

        number = new Number(1);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(true).setRenderingOnes(false);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals("+")) {
            errorMessage = firstHalf + "+" + secondHalf + number;
            return false;
        }

        number = new Number(1);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(false).setRenderingOnes(true);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals("1")) {
            errorMessage = firstHalf + "1" + secondHalf + number;
            return false;
        }

        number = new Number(1);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(true).setRenderingOnes(true);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals("+1")) {
            errorMessage = firstHalf + "+1" + secondHalf + number;
            return false;
        }

        number = new Number(1);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(false).setRenderingOnes(false);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().isEmpty()) {
            errorMessage = firstHalf + secondHalf + number;
            return false;
        }

        number = new Number(-1);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(true).setRenderingOnes(false);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals("-")) {
            errorMessage = firstHalf + "-" + secondHalf + number;
            return false;
        }

        number = new Number(-1);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(false).setRenderingOnes(true);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals("-1")) {
            errorMessage = firstHalf + "-1" + secondHalf + number;
            return false;
        }

        number = new Number(-1);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(true).setRenderingOnes(true);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals("-1")) {
            errorMessage = firstHalf + "-1" + secondHalf + number;
            return false;
        }

        number = new Number(-1);
        expressionSettings = new ExpressionSettings().setRenderingLeadingPluses(false).setRenderingOnes(false);
        number.setExpressionSettings(expressionSettings);
        if (!number.toString().equals("-")) {
            errorMessage = firstHalf + "-" + secondHalf + number;
            return false;
        }
        return true;
    }

    public static boolean numberAdditionNumber() {
        int value1;
        int value2;
        Random ran = new Random();
        int limit = 1000;
        for (int i = 0; i < GENERAL_TEST_AMOUNT; i++) {
            value1 = ran.nextInt(limit * -1, limit + 1);
            value2 = ran.nextInt(limit * -1, limit + 1);
            if (!numberAdditionTestHelp(value1, value2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean numberAdditionTestHelp(int x, int y) {
        Number n1 = new Number(x);
        Number n2 = new Number(y);
        Number result = (Number) n1.add(n2);
        if (n1 == result || n2 == result) {
            errorMessage = "Error: Operation did not create a new Number Object";
            return false;
        }
        if (result.getValue() != x + y) {
            errorMessage = "Error: Value of addition" + x + "+" + y + " should be \"" + (x + y) + "\". Observed " + result.getValue();
            return false;
        }
        return true;
    }

    public static boolean numberSubtractionNumber() {
        int value1;
        int value2;
        Random ran = new Random();
        int limit = 1000;
        for (int i = 0; i < GENERAL_TEST_AMOUNT; i++) {
            value1 = ran.nextInt(limit * -1, limit + 1);
            value2 = ran.nextInt(limit * -1, limit + 1);
            if (!numberSubtractionTestHelp(value1, value2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean numberSubtractionTestHelp(int x, int y) {
        Number n1 = new Number(x);
        Number n2 = new Number(y);
        Number result = (Number) n1.sub(n2);

        if (n1 == result || n2 == result) {
            errorMessage = "Error: Operation did not create a new Number Object";
            return false;
        }
        if (result.getValue() != x - y) {
            errorMessage = "Error: Value of subtraction " + x + "-" + y + " should be \"" + (x - y) + "\". Observed " + result.getValue();
            return false;
        }
        return true;
    }

    public static boolean numberMultiplicationNumber() {
        int value1;
        int value2;
        Random ran = new Random();
        int limit = 1000;
        for (int i = 0; i < GENERAL_TEST_AMOUNT; i++) {
            value1 = ran.nextInt(limit * -1, limit + 1);
            value2 = ran.nextInt(limit * -1, limit + 1);
            if (!numberMultiplicationTestHelp(value1, value2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean numberMultiplicationTestHelp(int x, int y) {
        Number n1 = new Number(x);
        Number n2 = new Number(y);
        Number result = (Number) n1.mul(n2);

        if (n1 == result || n2 == result) {
            errorMessage = "Error: Operation did not create a new Number Object";
            return false;
        }
        if (result.getValue() != x * y) {
            errorMessage = "Error: Value of multiplication  " + x + "*" + y + " should be \"" + (x * y) + "\". Observed " + result.getValue();
            return false;
        }
        return true;
    }

    public static boolean numberDivisionNumber() {
        Random ran = new Random();
        int limit = 1000;
        int value1;
        int value2;
        for (int i = 0; i < GENERAL_TEST_AMOUNT; i++) {
            value1 = ran.nextInt(limit * -1, limit + 1);
            do {
                value2 = ran.nextInt(limit * -1, limit + 1);
            } while (value2 == 0);

            if (!numberDivisionTestHelp(value1, value2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean numberDivisionTestHelp(int x, int y) {
        Number n1 = new Number(x);
        Number n2 = new Number(y);
        Expression unknownResult;
        try {
            unknownResult = n1.div(n2);
        } catch (Exception e) {
            return true;
        }

        if (n1 == unknownResult || n2 == unknownResult) {
            errorMessage = "Operation did not create a new Number Object from division " + x + "/" + y;
            return false;
        }

        if (x % y != 0 && !(unknownResult instanceof Fraction)) {
            errorMessage = "Operation should have returned a Fraction with expected values " + x + "/" + y;
            return false;
        }

        if (unknownResult instanceof Fraction f) {
            if (!(f.getNumerator() instanceof Number)) {
                errorMessage = "Numerator with value " + x + " has not been successfully created as a type Number";
                return false;
            }

            if (!(f.getDenominator() instanceof Number)) {
                errorMessage = "Denominator with value " + y + " has not been successfully created as a type Number";
                return false;
            }

            int x2 = ((Number) f.getNumerator()).getValue();
            int y2 = ((Number) f.getDenominator()).getValue();
            if (y < 0) {
                x *= -1;
                y *= -1;
            }
            if (x != x2 || y != y2) {
                errorMessage = "From operation created Fraction has wrong values. Expected: \"" + x + "/" +
                        y + "\". Observed: " + x2 + "/" + y2 + ".";
                return false;
            }
            return true;
        }

        Number numberResult = (Number) unknownResult;
        if (numberResult.getValue() != x / y) {
            errorMessage = "Value of division " + x + "/" + y + " should be \"" + (x / y) + "\". Observed " + numberResult.getValue();
            return false;
        }
        return true;
    }
}


