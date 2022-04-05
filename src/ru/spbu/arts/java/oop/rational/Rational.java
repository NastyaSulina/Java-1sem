package ru.spbu.arts.java.oop.rational;

public class Rational {
    private static final int ONE = 1;
    private static final int ZERO = 0;

    private int numerator;
    private int denominator = 1;

    public Rational(int numerator, int denominator) {
        if (denominator > 0) {
            int x = gcd(numerator, denominator);
            this.numerator = numerator / x;
            this.denominator = denominator / x;
        } else
            System.out.println("Знаменатель должен быть положительным и не равным 0!");
    }

    public Rational(int numerator) {
        this.numerator = numerator;
    }

    public String toString() {
        if (numerator == 0)
            return "0";
        if (denominator == 1)
            return String.valueOf(numerator);
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public Rational add(Rational other) {
        int x = numerator * other.denominator + denominator * other.numerator;
        int y = denominator * other.denominator;
        return new Rational(x, y);
    }


//    // Статическая версия add
//    public static Rational add(Rational first, Rational second) {
//        int x = first.numerator * second.denominator + first.denominator * second.numerator;
//        int y = first.denominator * second.denominator;
//        return new Rational(x, y);
//    }

    public Rational sub(Rational other) {
        int x = numerator * other.denominator - denominator * other.numerator;
        int y = denominator * other.denominator;
        return new Rational(x, y);
    }

    public Rational mul(Rational other) {
        int x = numerator * other.numerator;
        int y = denominator * other.denominator;
        return new Rational(x, y);
    }

    public Rational div(Rational other) {
        int x = numerator * other.denominator;
        int y = denominator * other.numerator;
        return new Rational(x, y);
    }

//    public void addInPlace(Rational other) {
//        numerator = numerator * other.denominator + denominator * other.numerator;
//        denominator = denominator * other.denominator;
//        this.simplify();
//    }
//
//    public void subInPlace(Rational other) {
//        numerator = numerator * other.denominator - denominator * other.numerator;
//        denominator = denominator * other.denominator;
//        this.simplify();
//    }
//
//    public void mulInPlace(Rational other) {
//        numerator = numerator * other.numerator;
//        denominator = denominator * other.denominator;
//        this.simplify();
//    }
//
//    public void divInPlace(Rational other) {
//        numerator = numerator * other.denominator;
//        denominator = denominator * other.numerator;
//        this.simplify();
//    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    private static int gcd(int x, int y) {
        while (x != y) {
            if (x > y)
                x = x - y;
            else
                y = y - x;
        }
        return x;
    }

    private void simplify() {
        int x = gcd(numerator, denominator);
        numerator = numerator / x;
        denominator = denominator / x;
    }
}
