import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

public class ExamTask {
    public static void main(String[] args) throws Exception {
        int[] arrayOfNumbers = readNumbersFromFile();
        writeNumberToFile(arrayOfNumbers);
    }

    private static void writeNumberToFile(int[] array) throws Exception {
        try (PrintStream outFile = new PrintStream("text-files/second.txt", StandardCharsets.UTF_8)) {
            int max = isMaxNumber(array);
            for (int num : array) {
                int d = String.valueOf(max).length() - String.valueOf(num).length();
                for (int j = 0; j < d; j++)
                    outFile.print(" ");
                outFile.println(num);
            }
            outFile.flush();
        }
    }

    private static int isMaxNumber(int[] array) {
        int maxNumber = 0;
        for (int j : array) {
            if (j > maxNumber)
                maxNumber = j;
        }
        return maxNumber;
    }

    private static int[] readNumbersFromFile() throws Exception {
        Path txt = Path.of("text-files/first.txt");
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            int firstNumber = in.nextInt();
            int[] array = new int[firstNumber];
            for (int i = 0; i < firstNumber; i++)
                array[i] = in.nextInt();
            return array;
        }
    }
}
