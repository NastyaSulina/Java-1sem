package ru.spbu.arts.java.lambdas;

public class PrintableLetter implements Printable {
    String str; int count;

    public PrintableLetter(String str, int count) {
        this.str = str;
        this.count = count;
    }

    @Override
    public void print() {
        System.out.println(str.repeat(count));
    }
}
