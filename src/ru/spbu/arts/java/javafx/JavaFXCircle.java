package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class JavaFXCircle extends Application {
    public Slider slider;
    public Circle circle;
    public Pane panelR;
    public ColorPicker colorForCircle;
    public ColorPicker colorForBackground;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Управление кругом");
        Parent parent = initInterface();

        initInteraction();
        primaryStage.setScene(new Scene(parent, 500, 400));
        primaryStage.show();
    }

    private void initInteraction() {
        // Связь радиуса круга и свойство value у slider.
        circle.radiusProperty().bind(
                slider.valueProperty()
        );
        // Связь x-координаты центра круга с половиной свойства width у Pane.
        circle.centerYProperty().bind(
                Bindings.divide(panelR.heightProperty(), 2)
        );
        // Связь y-координаты центра круга с половиной свойства width у Pane.
        circle.centerXProperty().bind(
                Bindings.divide(panelR.widthProperty(), 2)
        );

        // Связь цвета круга со свойством value у первого ColorPicker.
        colorForCircle.setValue((Color) circle.getFill());
        colorForCircle.valueProperty().addListener(o -> circle.setFill(colorForCircle.getValue()));

        // Связь background для Pane со свойством value у второго ColorPicker.
        colorForBackground.valueProperty().addListener(o -> panelR.setBackground(new Background(new BackgroundFill(colorForBackground.getValue(), null, null))));

        // Максимальное значение слайдера
        slider.maxProperty().bind(
                Bindings.divide(Bindings.min(panelR.heightProperty(), panelR.widthProperty()), 2)
        );
    }

    private Parent initInterface() {
        HBox panel = new HBox();

        VBox panelL = new VBox();
        panelR = new Pane();

        Label labelForSlider = new Label("Радиус");
        slider = new Slider();
        Label labelForColorCircle = new Label("Цвет");
        colorForCircle = new ColorPicker();
        Label labelForColorField = new Label("Цвет фона");
        colorForBackground = new ColorPicker();
        circle = new Circle();

        slider.setMin(0);
        panelL.setStyle("-fx-background-color: #dadada");
        panelL.setSpacing(15);
        panelL.setPrefWidth(300);

        HBox.setHgrow(panelR, Priority.ALWAYS);

        panelL.getChildren().addAll(labelForSlider, slider, labelForColorCircle, colorForCircle, labelForColorField, colorForBackground);
        panelR.getChildren().addAll(circle);
        panel.getChildren().addAll(panelL, panelR);

        return panel;
    }
}
