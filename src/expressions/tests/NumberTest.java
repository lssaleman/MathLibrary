package expressions.tests;

import expressions.Expression;
import expressions.Fraction;
import expressions.Number;
import util.Notifications;

import java.util.Random;

public class NumberTest {
    public static final int GENERAL_TEST_AMOUNT = 30;
    private static String errorMessage = "";

    private static final String NUMBER_INIT = "NUMBER_INIT";
    private static final String NUMBER_ADDITION_NUMBER = "NUMBER_ADDITION_NUMBER";
    private static final String NUMBER_SUBTRACTION_NUMBER = "NUMBER_SUBTRACTION_NUMBER";
    private static final String NUMBER_MULTIPLICATION_NUMBER = "NUMBER_MULTIPLICATION_NUMBER";
    private static final String NUMBER_DIVISION_NUMBER = "NUMBER_DIVISION_NUMBER";


    public static void main(String[] args) {
        startNumberTesting();
    }

    public static void startNumberTesting() {
        if (!initTest()) {
            System.out.println(Notifications.FAILED + NUMBER_INIT);
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_INIT);
        }
        if(!numberAdditionNumber()) {
            System.out.println(Notifications.FAILED + NUMBER_ADDITION_NUMBER);
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_ADDITION_NUMBER);
        }
        if (!numberSubtractionNumber()) {
            System.out.println(Notifications.FAILED + NUMBER_SUBTRACTION_NUMBER);
            System.out.println(errorMessage);
        } else {
        System.out.println(Notifications.PASSED + NUMBER_SUBTRACTION_NUMBER);
        }
        if (!numberMultiplicationNumber()) {
            System.out.println(Notifications.FAILED + NUMBER_MULTIPLICATION_NUMBER);
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_MULTIPLICATION_NUMBER);
        }
        if (!numberDivisionNumber()) {
            System.out.println(Notifications.FAILED + NUMBER_DIVISION_NUMBER);
            System.out.println(errorMessage);
        } else {
            System.out.println(Notifications.PASSED + NUMBER_DIVISION_NUMBER);
        }
    }

    public static boolean initTest() {
        if (!initTestHelp(0)) {
            return false;
        }
        if (!initTestHelp(-100)) {
            return false;
        }
        if (!initTestHelp(478)) {
            return false;
        }
        int limit = 1000;
        return initTestHelp(new Random().nextInt(limit * -1, limit + 1));
    }

    public static boolean initTestHelp(int testValue) {
        Number number = new Number(testValue);
        if (number.getValue() != testValue) {
            errorMessage = "Error: Value should be " + testValue + ". Observed " + number.getValue();
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
            errorMessage = "Error: Value should be " + (x + y) + ". Observed " + result.getValue();
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
            errorMessage = "Error: Value should be " + (x - y) + ". Observed " + result.getValue();
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
            errorMessage = "Error: Value should be " + (x * y) + ". Observed " + result.getValue();
            return false;
        }
        return true;
    }

    public static boolean numberDivisionNumber() {
        int value1;
        int value2;
        Random ran = new Random();
        int limit = 1000;
        for (int i = 0; i < GENERAL_TEST_AMOUNT; i++) {
            value1 = ran.nextInt(limit * -1, limit + 1);
            value2 = ran.nextInt(limit * -1, limit + 1);
            if (!numberDivisionTestHelp(value1, value2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean numberDivisionTestHelp(int x, int y) {
        Number n1 = new Number(x);
        Number n2 = new Number(y);
        Expression unknownResult =  n1.div(n2);

        if (n1 == unknownResult || n2 == unknownResult) {
            errorMessage = "Error: Operation did not create a new Number Object";
            return false;
        }

        if (x % y != 0 && !(unknownResult instanceof Fraction)) {
            errorMessage = "Error: Operation should have returned a Fraction but returned a Number instead";
            return false;
        }

        if (unknownResult instanceof Fraction f) {
            if (y < 0) {
                x *= -1;
                y *=-1;
            }

            if (!(f.getNumerator() instanceof Number)) {
                errorMessage = "Error: Numerator has not been successfully created as a type Number";
                return false;
            }

            if (!(f.getDenominator() instanceof Number)) {
                errorMessage = "Error: Denominator has not been successfully created as a type Number";
                return false;
            }

            int x2 = ((Number) f.getNumerator()).getValue();
            int y2 = ((Number) f.getDenominator()).getValue();
            if (x != x2 || y != y2) {
                errorMessage = "Error: From operation created Fraction has wrong values. Expected: " + x +"/" +
                        y + " observed: " + x2 + "/" + y2 + ".";
                return false;
            }
            return true;
        }

        Number result = (Number) unknownResult;
        if (result.getValue() != x / y) {
            errorMessage = "Error: Value should be " + (x / y) + ". Observed " + result.getValue();
            return false;
        }
        return true;
    }
}


