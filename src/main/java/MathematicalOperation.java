public class MathematicalOperation {
    double firstNumber;
    double secondNumber;
    private Operators operators;

    public MathematicalOperation(double firstNamber, double secondNamber, Operators operators) {
        this.firstNumber = firstNamber;
        this.secondNumber = secondNamber;
        this.operators = operators;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(int firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Operators getOperators() {
        return operators;
    }

    public void setOperators(Operators operators) {
        this.operators = operators;
    }

    public double operation() {
        if (secondNumber == 0) {
            throw new ArithmeticException();
        }
        return switch (operators) {
            case ADDITION -> firstNumber + secondNumber;
            case SUBTRACTION -> firstNumber - secondNumber;
            case MULTIPLICATION -> firstNumber * secondNumber;
            case DIVISION -> firstNumber / secondNumber;
        };
    }

    @Override
    public String toString() {
        return firstNumber + " " + operators.getDescription() + " " + secondNumber + " = " + operation();
    }
}
