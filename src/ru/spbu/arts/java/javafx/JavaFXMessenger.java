package ru.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class JavaFXMessenger extends Application {

    private Button submitButton;
    private ObservableList<String> names;
    private TextField text1;
    private TextArea text2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Интерфейс мессенджера");
        Parent parent = initInterface();
        initInteraction();

        addContacts("Мария");
        addContacts("Михаил");
        addContacts("Полина");

        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
    private void initInteraction() {
        submitButton.addEventHandler(ActionEvent.ACTION, event -> {
            text2.setText(text2.getText() + text1.getText() + "\n");
            text1.clear();
        });
    }

    private Parent initInterface() {
        GridPane pane = new GridPane();

        submitButton = new Button("Послать");
        Label labelContacts = new Label("Контакты");
        text1 = new TextField();
        text2 = new TextArea();
        names = FXCollections.observableArrayList();
        ListView<String> listContacts = new ListView<>(names);

        labelContacts.setStyle("-fx-background-color: #f1f1f1");
        submitButton.setMaxWidth(10000);
        submitButton.setMaxHeight(10000);
        text1.setMaxHeight(10000);
        text2.setDisable(true);

        pane.add(text2, 0,0,2,2);
        pane.add(labelContacts, 2,0);
        pane.add(listContacts, 2,1, 1, 2);
        pane.add(text1, 0,2);
        pane.add(submitButton, 1,2);

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHgrow(Priority.ALWAYS);
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPrefWidth(150);
        ColumnConstraints c3 = new ColumnConstraints();
        c3.setPrefWidth(200);

        pane.getColumnConstraints().addAll(c1, c2, c3);

        RowConstraints r1 = new RowConstraints();
        r1.setPercentHeight(10);
        RowConstraints r2 = new RowConstraints();
        r2.setVgrow(Priority.ALWAYS);
        RowConstraints r3 = new RowConstraints();
        r3.setPercentHeight(20);

        pane.getRowConstraints().addAll(r1, r2, r3);

        return pane;
    }

    private void addContacts(String name) {
        names.add(name);
    }
}
