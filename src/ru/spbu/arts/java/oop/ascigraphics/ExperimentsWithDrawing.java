package ru.spbu.arts.java.oop.ascigraphics;

public class ExperimentsWithDrawing {
    public static void main(String[] args) {
        Drawing d = new Drawing(10, 10, '.');

        d.setPoint(5, 5, '@');
        d.print();

        System.out.println("==============================================");

        d.drawVerticalLine(2, 4, 9, '$');
        d.drawHorizontalLine(2, 4, 9, 'o');
        d.print();

        System.out.println("==============================================");
        Drawing d1 = new Drawing(10, 10, '.');
        d1.drawRectangle(2,3,7,8, '^');
        d1.print();

        System.out.println("==============================================");
        Drawing d2 = new Drawing(9, 9, '.');
        d2.drawCircle(4,4, 4,'o');
        d2.print();

        System.out.println("==============================================");
        Drawing d3 = new Drawing(15, 15, '.');
        d3.draw(6,6, d2);
        d3.print();

        System.out.println("========== Рисую почти многоэтажку :) ===============");
        Drawing d4 = new Drawing(20, 20, '.');

        d4.drawVerticalLine(5,0,17, '|');
        d4.drawVerticalLine(11,0,17, '|');
        d4.drawHorizontalLine(17,4,12, '■');
        d4.drawHorizontalLine(0,0,19, '^');
        d4.drawRectangle(7,13,9,15, '■');
        d4.drawRectangle(7,9,9,11, '■');
        d4.drawRectangle(7,1,9,7, '■');

        // Рисую солнышко
        Drawing sunPicture = new Drawing(6, 5, '.');
        sunPicture.drawCircle(2,2, 2,'o');
        d4.draw(15,14, sunPicture);

        d4.print();
    }
}
