package ru.spbu.arts.java.oop.rational;

public class ExperimentsWithRational {
    public static void main(String[] args) {
        Rational r = new Rational(14, 7);
        Rational r2 = new Rational(23);
        Rational r3 = new Rational(7, 29);
        Rational r4 = new Rational(65, 10);

        System.out.println(r);
        System.out.println(r2);
        System.out.println(r3);

        System.out.println(r.toDouble());
        System.out.println(r2.toDouble());
        System.out.println(r3.toDouble());

        System.out.println(r.add(r4));
        System.out.println(r2.div(r3));
        System.out.println(r4.mul(r2));
        System.out.println(r.sub(r3));

        System.out.println(harmonicSeries(1));
        System.out.println(harmonicSeries(2));
        System.out.println(harmonicSeries(3));
        System.out.println(harmonicSeries(19));
        System.out.println(harmonicSeries(20));
        System.out.println(harmonicSeries(21));

        System.out.println(r2.getNumerator());
        System.out.println(r2.getDenominator());

        // System.out.println(add(r4, r2)); // Для статической версии add

        System.out.println("-------------harmonicSeries2------");
        System.out.println(harmonicSeries2(1));
        System.out.println(harmonicSeries2(2));
        System.out.println(harmonicSeries2(3));
        System.out.println(harmonicSeries2(19));
        System.out.println(harmonicSeries2(20));
        System.out.println(harmonicSeries2(21));
    }
    public static double harmonicSeries(int n){
        Rational sum = new Rational(0);
        for (int i = 1; i <= n; i++) {
            var temp = new Rational(1, i);
            sum = sum.add(temp);
        }
        return sum.toDouble();
    } // Проблема с f(20) и далее

    public static double harmonicSeries2(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            var temp = new Rational(1, i).toDouble();
            sum += temp;
        }
        return sum;
    } // Работает для f(20) и далее
}
