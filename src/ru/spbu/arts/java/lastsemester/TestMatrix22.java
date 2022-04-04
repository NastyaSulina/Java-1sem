package ru.spbu.arts.java.lastsemester;

import java.util.Arrays;

public class TestMatrix22 {
    public static void main(String[] args) {
        Matrix22 m1 = new Matrix22(2, 3, 5, 6);
        Matrix22 m2 = new Matrix22(new double[][]{{6, 100}, {2000, 9}});

        System.out.println(m1.Discriminant());
        System.out.println(m1.Trace());
        System.out.println(Arrays.deepToString(m2.getArray()));
        System.out.println(m2);
        m2.print();

        System.out.println(m1.add(m2));
        System.out.println(m1.mul(m2));
        System.out.println(m1.pow(5));

        System.out.println(getFibonacci(0));
        System.out.println(getFibonacci(1));
        System.out.println(getFibonacci(2));
        System.out.println(getFibonacci(3));
        System.out.println(getFibonacci(4));
    }
    public static double getFibonacci(int n) {
        if (n == 0)
            return 0;
        else {
            Matrix22 m = new Matrix22(1, 1, 1, 0);
            double[][] result = m.pow(n - 1).getArray();
            return result[0][0];
        }
    }
}
