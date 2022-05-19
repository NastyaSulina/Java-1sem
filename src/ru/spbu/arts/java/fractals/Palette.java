package ru.spbu.arts.java.fractals;

import javafx.scene.paint.Color;

public interface Palette {

    // Преобразовывает число от 0 до 1 в цвет
    Color getColor(double c);

}
