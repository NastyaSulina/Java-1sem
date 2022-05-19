package ru.spbu.arts.java.fractals;

public class MandelbrotFractal implements Fractal {
    @Override
    public double evaluate(double x, double y) {

        double zx = 0;
        double zy = 0;

        int R = 100000;

        for (double j = 0; j < 100; j++) {
            double re = Math.pow(zx, 2) - Math.pow(zy, 2) + x;
            double im = 2 * zx * zy + y;
            zx = re;
            zy = im;

            if (zx * zx + zy * zy > R * R)
                return j / 100;
        }
        return 0.75;
    }
}
