package expressions.tests;

import util.Notifications;

import java.util.ArrayList;

public class TestSuite {
    private static final ArrayList<String> failedTests = new ArrayList<>();
    public static void main(String[] args) {
        NumberTest.startNumberTests(failedTests);
        FractionTest.startFractionTests(failedTests);

            System.out.println();
        if (!failedTests.isEmpty()) {
            System.out.println(Notifications.FAILURE + "Some Tests have failed");
            for(String failedTest : failedTests) {
                System.out.println(failedTest);
            }
        } else {
            System.out.println(Notifications.SUCCESS + "All tests passed successfully");
        }
    }
}
