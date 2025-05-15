package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class App12 extends Application {
    public static void main(String[] args){
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = new AnchorPane();
        Button button = new Button();
        TextField textField = new TextField("что-то важное");
        Label label = new Label();

        AnchorPane.setRightAnchor(button,50.0);
        AnchorPane.setLeftAnchor(button,50.0);
        AnchorPane.setTopAnchor(button,50.0);
        AnchorPane.setBottomAnchor(button,50.0);

        AnchorPane.setRightAnchor(textField,50.0);
        AnchorPane.setLeftAnchor(textField,50.0);
        AnchorPane.setTopAnchor(textField,1.0);
        AnchorPane.setBottomAnchor(textField,150.0);

        AnchorPane.setRightAnchor(label,50.0);
        AnchorPane.setLeftAnchor(label,50.0);
        AnchorPane.setTopAnchor(label,150.0);
        AnchorPane.setBottomAnchor(label,1.0);

        button.addEventHandler(ActionEvent.ACTION, event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText(LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString());
            alert.show();
            String text = textField.getText();
            label.setText(text);
        });
        pane.getChildren().addAll(button,textField,label);
        Scene scene = new Scene(pane,200,200);
        stage.setScene(scene);
        stage.setTitle("0_0");
        stage.show();
    }
}
