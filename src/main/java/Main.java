import java.io.FileNotFoundException;
import java.io.IOException;

class Main {
    public static void main(String[] args) {
        String fileToRead = "operations.txt";
        String fileToSave = "zapis.txt";
        try {
            MathematicalOperation[] mathematicalOperations = FileUtils.read(fileToRead);
            for (MathematicalOperation mathematicalOperation : mathematicalOperations) {
                System.out.println(mathematicalOperation.toString());
            }
            FileUtils.save(mathematicalOperations, fileToSave);
        } catch (FileNotFoundException e) {
            System.err.printf("Nie można otworzyć pliku: %s", fileToRead);
        } catch (ArithmeticException e) {
            System.err.print("Nie można dzielić przez 0");
        } catch (IOException e) {
            System.err.printf("Nie można zapisać wyniku do pliku %s", fileToSave);
        }
    }
}