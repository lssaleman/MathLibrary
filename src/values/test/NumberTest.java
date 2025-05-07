package values.test;

import values.Expression;
import values.Fraction;
import values.Number;

import java.util.Random;

public class NumberTest {
    public static final int GENERAL_TEST_AMOUNT = 30;
    public static void main(String[] args) {
        startNumberTesting();
    }

    public static void startNumberTesting() {
        if (!initTest()) {
            System.out.println("Error: NUMBER_INIT");
        } else {
            System.out.println("Passed: NUMBER_INIT");
        }
        if(!numberAdditionTest()) {
            System.out.println("Error: NUMBER_ADDITION");
        } else {
            System.out.println("Passed: NUMBER_ADDITION");
        }
        if (!numberSubtractionTest()) {
            System.out.println("Error: NUMBER_SUBTRACTION");
        } else {
        System.out.println("Passed: NUMBER_SUBTRACTION");
        }
        if (!numberMultiplicationTest()) {
            System.out.println("Error: NUMBER_MULTIPLICATION");
        } else {
            System.out.println("Passed: NUMBER_MULTIPLICATION");
        }
        if (!numberDivisionTest()) {
            System.out.println("Error: NUMBER_DIVISION");
        } else {
            System.out.println("Passed: NUMBER_DIVISION");
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
            System.out.println("Error: Value should be " + testValue + ". Observed " + number.getValue());
            return false;
        }
        return true;
    }

    public static boolean numberAdditionTest() {
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
            System.out.println("Error: Operation did not create a new Number Object");
            return false;
        }
        if (result.getValue() != x + y) {
            System.out.println("Error: Value should be " + (x + y) + ". Observed " + result.getValue());
            return false;
        }
        return true;
    }

    public static boolean numberSubtractionTest() {
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
            System.out.println("Error: Operation did not create a new Number Object");
            return false;
        }
        if (result.getValue() != x - y) {
            System.out.println("Error: Value should be " + (x - y) + ". Observed " + result.getValue());
            return false;
        }
        return true;
    }

    public static boolean numberMultiplicationTest() {
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
            System.out.println("Error: Operation did not create a new Number Object");
            return false;
        }
        if (result.getValue() != x * y) {
            System.out.println("Error: Value should be " + (x * y) + ". Observed " + result.getValue());
            return false;
        }
        return true;
    }

    public static boolean numberDivisionTest() {
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
            System.out.println("Error: Operation did not create a new Number Object");
            return false;
        }

        if (x % y != 0 && !(unknownResult instanceof Fraction)) {
            System.out.println("Error: Operation should have returned a Fraction but returned a Number instead");
            return false;
        }

        if (unknownResult instanceof Fraction f) {
            if (y < 0) {
                x *= -1;
                y *=-1;
            }

            if (!(f.getNumerator() instanceof Number)) {
                System.out.println("Error: Numerator has not been successfully created as a type Number");
                return false;
            }

            if (!(f.getDenominator() instanceof Number)) {
                System.out.println("Error: Denominator has not been successfully created as a type Number");
                return false;
            }

            int x2 = ((Number) f.getNumerator()).getValue();
            int y2 = ((Number) f.getDenominator()).getValue();
            if (x != x2 || y != y2) {
                System.out.println("Error: From operation created Fraction has wrong values. Expected: " + x +"/" +
                        y + " observed: " + x2 + "/" + y2 + ".");
                return false;
            }
            return true;
        }

        Number result = (Number) unknownResult;
        if (result.getValue() != x / y) {
            System.out.println("Error: Value should be " + (x / y) + ". Observed " + result.getValue());
            return false;
        }
        return true;
    }
}


