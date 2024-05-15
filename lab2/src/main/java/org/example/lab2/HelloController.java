package org.example.lab2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {
    @FXML
    private TextField studentId;
    @FXML
    private TextField studentName;
    @FXML
    private TextField studentMajor;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, Integer> columnId;
    @FXML
    private TableColumn<Student, String> columnName;
    @FXML
    private TableColumn<Student, String> columnMajor;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;

    private ObservableList<Student> students = FXCollections.observableArrayList();
    private SortedList<Student> sortedStudents = new SortedList<>(students);

    @FXML
    public void initialize() {
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnMajor.setCellValueFactory(new PropertyValueFactory<>("major"));
        sortedStudents.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedStudents);
    }

    @FXML
    private void addStudent() {
        try {
            int id = Integer.parseInt(studentId.getText());
            String name = studentName.getText();
            String major = studentMajor.getText();
            students.add(new Student(id, name, major));
            clearFields();
        } catch (NumberFormatException e) {
            System.out.println("Error: ID should be a integer");
        }
    }

    @FXML
    private void deleteStudent() {  //not working
        Student selected = tableView.getSelectionModel().getSelectedItem();
        students.remove(selected);
    }

    private void clearFields() {
        studentId.clear();
        studentName.clear();
        studentMajor.clear();
    }
}
