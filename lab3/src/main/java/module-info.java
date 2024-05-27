module org.example.lab3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.lab3 to javafx.fxml;
    exports org.example.lab3;
}