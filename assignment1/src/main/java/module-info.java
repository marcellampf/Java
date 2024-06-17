module org.example.assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.assignment1 to javafx.fxml;
    exports org.example.assignment1;
}
