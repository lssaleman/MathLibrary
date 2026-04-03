package expressions.settings;

public class ExpressionSettings {
    private boolean renderingLeadingPluses = false;
    private boolean renderingOnes = true;
    private boolean automaticallyOptimizing = false;
    private boolean automaticallyPassingSettingsToChildren = false;

    public boolean isRenderingLeadingPluses() {
        return renderingLeadingPluses;
    }

    public ExpressionSettings setRenderingLeadingPluses(boolean renderingLeadingPluses) {
        this.renderingLeadingPluses = renderingLeadingPluses;
        return this;
    }

    public boolean isRenderingOnes() {
        return renderingOnes;
    }

    public ExpressionSettings setRenderingOnes(boolean renderingOnes) {
        this.renderingOnes = renderingOnes;
        return this;
    }

    public boolean isAutomaticallyOptimizing() {
        return automaticallyOptimizing;
    }

    public ExpressionSettings setAutomaticallyOptimizing(boolean automaticallyOptimizing) {
        this.automaticallyOptimizing = automaticallyOptimizing;
        return this;
    }

    public boolean isAutomaticallyPassingSettingsToChildren() {
        return automaticallyPassingSettingsToChildren;
    }

    public ExpressionSettings setAutomaticallyPassingSettingsToChildren(boolean automaticallyPassingSettingsToChildren) {
        this.automaticallyPassingSettingsToChildren = automaticallyPassingSettingsToChildren;
        return this;
    }

    public ExpressionSettings copy() {
        return new ExpressionSettings()
                .setRenderingOnes(this.renderingOnes)
                .setRenderingLeadingPluses(this.renderingLeadingPluses)
                .setAutomaticallyOptimizing(this.automaticallyOptimizing)
                .setAutomaticallyPassingSettingsToChildren(this.automaticallyPassingSettingsToChildren);
    }
}
