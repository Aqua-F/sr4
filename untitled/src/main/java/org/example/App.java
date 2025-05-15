package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class App extends Application {
    public static void main(String[] args){
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = new AnchorPane();

        Label label = new Label("Это текст");
        label.setLayoutX(20);
        label.setLayoutY(30);

        Button button1 = new Button("А это кнопка 1");
        button1.setLayoutX(20);
        button1.setLayoutY(60);
        button1.addEventHandler(ActionEvent.ACTION, event -> {
            try {
                System.out.write("Нажата кнопка!\n".getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        button1.fire();

        Button button2 = new Button("А это кнопка 2");
        button2.setLayoutX(20);
        button2.setLayoutY(90);

        pane.getChildren().add(label);
        pane.getChildren().add(button1);
        pane.getChildren().add(button2);
        Scene scene = new Scene(pane,300,200);
        stage.setScene(scene);
        stage.show();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("inform menu");
        alert.show();
    }
}