package ru.spbu.arts.java.lambdas;

import ru.spbu.arts.java.oop.ascigraphics.Drawing;

import java.util.Date;

public class Test {
    public static void main(String[] args) {

        PrintableLetter pl = new PrintableLetter("x", 10);
        pl.print(); //печатает букву x 10 раз

        PrintableString ps = new PrintableString("asdf");
        ps.print(); //печатает asdf

        Printable currentDate = () -> System.out.println(new Date());

        Printable goodDay = new Printable() {
            @Override
            public void print() {
                System.out.println("Хорошего дня!");
            }
        };

        Printable[] elements = {new Drawing(10, 10, '*'), pl, ps, currentDate, goodDay};
        for (Printable element : elements)
            element.print();
    }
}
