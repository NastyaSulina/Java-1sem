package ru.spbu.arts.java.fractals;

import javafx.scene.paint.Color;

public class GrayscalePalette implements Palette{


    @Override
    public Color getColor(double c) {

        return Color.gray(1 - c);

    }
}
