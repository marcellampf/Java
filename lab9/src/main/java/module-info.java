module org.example.lab9 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens org.example.lab9 to javafx.fxml;
    exports org.example.lab9;
}