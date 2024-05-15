module org.example.lab2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.lab2 to javafx.fxml;
    exports org.example.lab2;
}