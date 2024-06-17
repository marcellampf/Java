package org.example.lab5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.regex.Pattern;

public class HelloController {

    @FXML
    private TextField emailField;

    @FXML
    private Label resultLabel;

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @FXML
    public void validateEmail() {
        String email = emailField.getText();
        if (email != null && pattern.matcher(email).matches()) {
            resultLabel.setText("Email is valid");
        } else {
            resultLabel.setText("Email is invalid");
        }
    }
}
