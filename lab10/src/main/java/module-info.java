module org.example.lab10 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.net.http;
    requires com.google.gson;

    opens org.example.lab10 to javafx.fxml;
    exports org.example.lab10;
}