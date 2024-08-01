module org.example.assignment3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    opens org.example.assignment3 to javafx.fxml, com.google.gson;
    exports org.example.assignment3;
}
