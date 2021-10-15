import java.util.Arrays;

public class MultidimentionalArrays {
    public static void main(String[] args) {
        int[][] a = new int[][]{{10, 20, 30}, {40, 50, 60, 70, 80, 90}, {100, 200}};
        printTableInt(a);
        printTableAligned(a);

        char[][] c = createTable(20, '.');
        printTable(c);

        System.out.println("============ Заполним строки: ==========");
        fillFirstAndLastLines(c, '#');
        printTable(c);

        System.out.println("============ Заполним столбцы: =========");
        fillFirstAndLastColumns(c, '#');
        printTable(c);
    }
    private static void printTableInt(int[][] a){
        for (int[] line : a) {
            String linestring = "";
            for (int c : line)
                linestring += c + " ";
            System.out.println(linestring);
        }
//        for (int[] x : a)
//            System.out.println(Arrays.toString(x));
    }
    private static void printTableAligned(int[][] a){
        int len = 0;
        for (int[] line : a)
            if (line.length > len)
                len = line.length; // Узнаю количество столбцов в таблице
        int[] arrayOfLengths = new int[len]; // Вспомогательный массив длинн
        for (int[] line : a) {
            for (int i = 0; i < line.length; i++)
                if (String.valueOf(line[i]).length() > arrayOfLengths[i])
                    arrayOfLengths[i] = String.valueOf(line[i]).length();
        }
        int d;
        for (int[] line : a) {
            for (int i = 0; i < line.length; i++) {
                d = arrayOfLengths[i] - String.valueOf(line[i]).length();
                if (i != 0)
                    System.out.print("  ");
                for (int j = 0; j < d; j++)
                    System.out.print(" ");
                System.out.print(line[i]);
            }
            System.out.print("\n");
        }
    }
    private static char[][] createTable(int number, char symbol){
        char[][] table = new char[number][number];
        for (char[] line : table)
            Arrays.fill(line, symbol);
        return table;
    }
    private static void printTable(char[][] table){
        for (char[] line : table) {
            String linestring = "";
            for (char c : line)
                linestring += c + " ";
            System.out.println(linestring);
        }
    }
    private static void fillFirstAndLastLines(char[][] table, char symbol){
        int l = table.length;
        Arrays.fill(table[0], symbol);
        Arrays.fill(table[l - 1], symbol);
    }
    private static void fillFirstAndLastColumns(char[][] table, char symbol){
        for (char[] line : table){
            line[0] = symbol;
            line[line.length - 1] = symbol;
        }
    }
}