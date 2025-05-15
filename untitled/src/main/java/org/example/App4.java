package org.example;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class App4 extends Application {
    public static void main(String[] args){
        launch();
    }
    public static class Student{
        private final int number;
        private final String name;
        private final String lesson;
        private int grade;

        public Student(int number, String name, String lesson, int grade) {
            this.number = number;
            this.name = name;
            this.lesson = lesson;
            this.grade = grade;
        }

        public int getNumber() {
            return number;
        }

        public String getName(){
            return name;
        }

        public String getLesson() {
            return lesson;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade){
            this.grade = grade;
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane = new AnchorPane();

        TableView<Student> tableView = new TableView<>();

        TableColumn<Student, String> numberColumn = new TableColumn<>("№");
        numberColumn.setCellValueFactory(new PropertyValueFactory<>("number"));
        TableColumn<Student, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Student, String> lessonColumn = new TableColumn<>("Предмет");
        lessonColumn.setCellValueFactory(new PropertyValueFactory<>("lesson"));
        TableColumn<Student, String> gradeColumn = new TableColumn<>("Оценка");
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

        tableView.getColumns().addAll(numberColumn,nameColumn,lessonColumn,gradeColumn);

        ObservableList<Student> students = FXCollections.observableArrayList(
                new Student(1,"Иван","Математика",5),
                new Student(2,"Тимофей","Математика",4),
                new Student(3,"Денис","Русский",4),
                new Student(4,"Ольга","Английский",3),
                new Student(5,"Сергей","Английский",2),
                new Student(6,"Анна","Русский",5),
                new Student(7,"Полина","Физика",4),
                new Student(8,"Алиса","Химия",3),
                new Student(9,"Глеб","Химия",3),
                new Student(10,"Павел","Математика",5)
        );

        tableView.setItems(students);
        tableView.setFixedCellSize(20);
        double maxHeight = (10*tableView.getFixedCellSize()+26);
        tableView.setMaxHeight(maxHeight);

        Label gradeLabel = new Label("Оценка:");
        TextField gradeField = new TextField();
        gradeField.setPromptText("1-5");

        Button updateButton = new Button("Внести изменения");

        updateButton.addEventHandler(ActionEvent.ACTION, event -> {
            Student selected = tableView.getSelectionModel().getSelectedItem();
            int newGrade = Integer.parseInt(gradeField.getText());

            if (newGrade >= 2 && newGrade <=5){
                selected.setGrade(newGrade);
                tableView.refresh();
            }else if (newGrade < 2) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("За что так с человеком то?");
                alert.show();
            }else if (newGrade > 5) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("А не слишком ли?");
                alert.show();
            }
        });

        HBox inputFields = new HBox(10,
                new VBox(5, gradeLabel, gradeField)
        );
        inputFields.setAlignment(Pos.CENTER);

        VBox controls = new VBox(10,inputFields,updateButton);
        controls.setAlignment(Pos.CENTER);

        AnchorPane.setRightAnchor(tableView, 10.0);
        AnchorPane.setLeftAnchor(tableView, 10.0);
        AnchorPane.setTopAnchor(tableView, 10.0);

        AnchorPane.setBottomAnchor(controls, 10.0);
        AnchorPane.setLeftAnchor(controls, 10.0);
        AnchorPane.setRightAnchor(controls, 10.0);

        pane.getChildren().addAll(tableView, controls);
        Scene scene = new Scene(pane,300,400);

        stage.setScene(scene);
        stage.setTitle("0_0");
        stage.show();
    }
}
