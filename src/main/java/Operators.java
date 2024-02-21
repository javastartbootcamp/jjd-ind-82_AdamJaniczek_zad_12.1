public enum Operators {
    ADDITION("+"), SUBTRACTION("-"), MULTIPLICATION("*"), DIVISION("/");
    private String description;

    Operators(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
