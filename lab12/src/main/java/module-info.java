module org.example.lab12 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.net.http;
    requires com.google.gson;

    opens org.example.lab12 to javafx.fxml, com.google.gson;
    exports org.example.lab12;
}
