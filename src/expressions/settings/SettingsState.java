package expressions.settings;

public class SettingsState {
    private static ExpressionSettings expressionSettings;

    private SettingsState() {}

    public static ExpressionSettings getExpressionSettings() {
        if (expressionSettings == null) {
            expressionSettings = new ExpressionSettings();
        }
        return expressionSettings;
    }

    public static void setExpressionSettings(ExpressionSettings newSettings) {
        expressionSettings = newSettings;
    }
}
