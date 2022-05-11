package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static ru.spbu.arts.java.javafx.LCH.colorFromLCH;
import static ru.spbu.arts.java.javafx.WaveToColorConverter.wavelengthToRGB;

public class JavaFXImages extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Работа с изображениями и цветом");
        Parent parent = initInterface();
        primaryStage.setScene(new Scene(parent, 600, 600));
        primaryStage.show();
    }

    private Parent initInterface() {
        // 1. Все пиксели имеют один и тот же цвет
        WritableImage image1 = new WritableImage(100, 100);
        PixelWriter pixelWriter1 = image1.getPixelWriter();
        for (int x = 0; x < image1.getWidth(); x++)
            for (int y = 0; y < image1.getHeight(); y++)
                pixelWriter1.setColor(x, y, Color.rgb(92, 160, 47));


        // 2. Пиксель с координатами (x, y) имеет цвет R = x, G = y, B = 123
        WritableImage image2 = new WritableImage(256, 256);
        PixelWriter pixelWriter2 = image2.getPixelWriter();
        for (int x = 0; x < image2.getWidth(); x++)
            for (int y = 0; y < image2.getHeight(); y++)
                pixelWriter2.setColor(x, y, Color.rgb(x, y, 123));

        // 3. Пиксель с координатами (x, y) имеет цвет H = x, S = y / 100, B = 0.5
        WritableImage image3 = new WritableImage(360, 100);
        PixelWriter pixelWriter3 = image3.getPixelWriter();
        for (int x = 0; x < image3.getWidth(); x++)
            for (int y = 0; y < image3.getHeight(); y++)
                pixelWriter3.setColor(x, y, Color.hsb(x, (double) y / 100, 0.5));

        // 4. Черный квадрат
        WritableImage image4 = new WritableImage(100, 100);
        PixelWriter pixelWriter4 = image4.getPixelWriter();
        for (int x = 0; x < image4.getWidth(); x++)
            for (int y = 0; y < image4.getHeight(); y++) {
                if (x >= 25 && x < 75 && y >= 25 && y < 75)
                    pixelWriter4.setColor(x, y, Color.BLACK);
                else
                    pixelWriter4.setColor(x, y, Color.WHITE);
            }

        // 5. Черный круг
        WritableImage image5 = new WritableImage(100, 100);
        PixelWriter pixelWriter5 = image5.getPixelWriter();
        for (int x = 0; x < image5.getWidth(); x++)
            for (int y = 0; y < image5.getHeight(); y++)
                if ((Math.pow(x - 50, 2) + Math.pow(y - 50, 2)) < 50 * 50)
                    pixelWriter5.setColor(x, y, Color.rgb(0, 0, 0));
                else
                    pixelWriter5.setColor(x, y, Color.rgb(255, 255, 255));

        // 6. Цветовое пространство LCH
        WritableImage image6 = new WritableImage(360, 100);
        PixelWriter pixelWriter6 = image6.getPixelWriter();
        for (int x = 0; x < image6.getWidth(); x++)
            for (int y = 0; y < image6.getHeight(); y++)
                pixelWriter6.setColor(x, y, colorFromLCH(50, y, x));

        // 7. Радуга. По горизонтали длина волны (от 380 до 750), по вертикали все цвета одинаковые
        WritableImage image7 = new WritableImage(750 - 380 + 1, 100);
        PixelWriter pixelWriter7 = image7.getPixelWriter();
        for (int x = 0; x < image7.getWidth(); x++) {
            Color color = wavelengthToRGB((double) x + 380);
            for (int y = 0; y < image7.getHeight(); y++)
                pixelWriter7.setColor(x, y, color);
        }

        ImageView viewer1 = new ImageView(image1);
        ImageView viewer2 = new ImageView(image2);
        ImageView viewer3 = new ImageView(image3);
        ImageView viewer4 = new ImageView(image4);
        ImageView viewer5 = new ImageView(image5);
        ImageView viewer6 = new ImageView(image6);
        ImageView viewer7 = new ImageView(image7);

        return new FlowPane(
                viewer1,
                viewer2,
                viewer3,
                viewer4,
                viewer5,
                viewer6,
                viewer7
        );
    }
}
