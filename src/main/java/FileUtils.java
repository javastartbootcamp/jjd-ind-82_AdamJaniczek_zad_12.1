import java.io.*;
import java.util.Scanner;

public class FileUtils {
    static MathematicalOperation[] read(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int lines = countLines(fileName);
        MathematicalOperation[] result = new MathematicalOperation[lines];
        for (int i = 0; i < lines; i++) {
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int firstNumber = Integer.parseInt(split[0]);
            int secondNumber = Integer.parseInt(split[2]);
            Operators operator = setOperator(split[1]);
            double price = Double.parseDouble(split[2]);
            result[i] = new MathematicalOperation(firstNumber, secondNumber, operator);
        }
        return result;
    }

    static void save(MathematicalOperation[] mathematicalOperations, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (MathematicalOperation mathematicalOperation : mathematicalOperations) {
            writer.write(mathematicalOperation.toString());
            writer.newLine();
        }
        writer.close();
    }

    private static Operators setOperator(String operator) {
        return switch (operator) {
            case "+":
                yield Operators.ADDITION;
            case "-":
                yield Operators.SUBTRACTION;
            case "*":
                yield Operators.MULTIPLICATION;
            case "/":
                yield Operators.DIVISION;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

    private static int countLines(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int lines = 0;
        while (scanner.hasNextLine()) {
            lines++;
            scanner.nextLine();
        }
        return lines;
    }
}
