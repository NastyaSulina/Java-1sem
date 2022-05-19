package ru.spbu.arts.java.fractals;

import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

// Хранит информацию о положении окна на математической плоскости
public class Display {

    private final double x0;
    private final double y0;
    private final double d;


    public Display(double x0, double y0, double d) {
        this.x0 = x0;
        this.y0 = y0;
        this.d = d;
    }

    public void paint(WritableImage image, Fractal fractal) {
        double w = image.getWidth();
        double h = image.getHeight();
        PixelWriter pixelWriter = image.getPixelWriter();

        GrayscalePalette grayscalePalette = new GrayscalePalette();
        HSBPalette hsbPalette = new HSBPalette();

        for (int xPixel = 0; xPixel < w; xPixel++)
            for (int yPixel = 0; yPixel < h; yPixel++) {
                double x = x0 + d * xPixel;
                double y = y0 - d * yPixel;
                double f = fractal.evaluate(x, y);
//                Color color = grayscalePalette.getColor(f);
                Color color = hsbPalette.getColor(f);

                pixelWriter.setColor(xPixel, yPixel, color);
            }
    }
}
