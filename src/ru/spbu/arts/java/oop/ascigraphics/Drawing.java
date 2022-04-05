package ru.spbu.arts.java.oop.ascigraphics;

import java.util.Arrays;
import ru.spbu.arts.java.lambdas.Printable;

public class Drawing implements Printable {

    private final int row;
    private final int column;
    private final char[][] array;

    public Drawing(int row, int column, char symbol) {
        this.row = row;
        this.column = column;
        this.array = new char[row][column];
        for (char[] line : array)
            Arrays.fill(line, symbol);
    }
    @Override
    public void print() {
        for (int i = array.length - 1; i >= 0; i--) {
            for (char c : array[i])
                System.out.print(c + "  ");
            System.out.println();
        }
    }

    public void setPoint(int x, int y, char s) {
        if (y < row && x < column && y >= 0 && x >= 0)
            array[x][y] = s;
        else
            System.out.println("Указанные координаты за границами рисунка!");
    }

    public void drawVerticalLine(int x, int y1, int y2, char s) {
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);
        if (maxY < row && x < column && minY >= 0 && x >= 0)
            for (int i = minY; i <= maxY; i++)
                array[i][x] = s;
        else
            System.out.println("Указанные координаты за границами рисунка!");
    }

    public void drawHorizontalLine(int y, int x1, int x2, char s) {
        int maxX = Math.max(x1, x2);
        int minX = Math.min(x1, x2);
        if (maxX < column && y < row && y >= 0 && minX >= 0)
            for (int i = minX; i <= maxX; i++)
                array[y][i] = s;
        else
            System.out.println("Указанные координаты за границами рисунка!");
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char s) {
        this.drawHorizontalLine(y1, x1, x2, s);
        this.drawHorizontalLine(y2, x1, x2, s);
        this.drawVerticalLine(x1, y1 + 1, y2 - 1, s);
        this.drawVerticalLine(x2, y1 + 1, y2 - 1, s);
    }

    public void drawCircle(int x, int y, int radius, char s) {
        if (y < row && x < column && y >= 0 && x >= 0) {
            if (radius > 0 && radius <= row - y && radius <= y) {
                for (int i = 0; i < column; i++)
                    for (int j = 0; j < row; j++)
                        if ((Math.pow(i - x, 2) + Math.pow(j - y, 2)) <= (radius * radius))
                            array[j][i] = s;
            } else
                System.out.println("Задайте корректный радиус!");
        } else
            System.out.println("Указанные координаты за границами рисунка!");
    }

    public void draw(int x, int y, Drawing sample) {
        if (y < row && x < column && y >= 0 && x >= 0 && (sample.column + x) <= column && (sample.row + y) <= row) {
            for (int i = 0; i < sample.row; i++)
                for (int j = 0; j < sample.column; j++)
                    array[y + i][x + j] = sample.array[i][j];
        } else
            System.out.println("Указанные координаты за границами рисунка!");
    }
}

