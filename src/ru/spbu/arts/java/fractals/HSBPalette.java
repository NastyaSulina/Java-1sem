package ru.spbu.arts.java.fractals;

import javafx.scene.paint.Color;

public class HSBPalette implements Palette{
    @Override
    public Color getColor(double c) {

        return Color.hsb(c * 360, 1, 1);

    }
}
