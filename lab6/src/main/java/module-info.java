module org.example.lab6 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.lab6 to javafx.fxml;
    exports org.example.lab6;
}