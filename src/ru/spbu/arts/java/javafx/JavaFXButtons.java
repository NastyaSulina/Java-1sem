package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class JavaFXButtons extends Application {
    private Button button;
    private int count = 0;
    private VBox panel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Кнопка “не нажимайте эту кнопку”");
        Parent parent = initInterface();
        initInteraction();

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    private void initInteraction() {
        String[] labels = {"Пожалуйста, не нажимайте больше эту кнопку", "Зачем вы нажали?", "Зачем вы продолжаете нажимать?!",
                "Это большая ошибка!", "Я предупреждаю вас, хватит.", "Это было последнее предупреждение..."};

        button.addEventHandler(ActionEvent.ACTION, event -> {
            if (count < labels.length) {
                button.setText(labels[count]);
                count++;
            } else {
                File file = new File("images/cat.jpg");
                panel.getChildren().clear();
                panel.getChildren().add(new ImageView(new Image(file.toURI().toString(), 400, 400, true, false)));
            }
        });
    }

    private Parent initInterface() {
        panel = new VBox();
        button = new Button("Не нажимайте эту кнопку!");

        panel.getChildren().addAll(button);
        panel.setPrefSize(400, 400);
        panel.setAlignment(Pos.CENTER);

        return panel;
    }
}
