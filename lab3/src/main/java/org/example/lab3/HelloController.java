package org.example.lab3;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController {
    @FXML
    private Button buttonAnonymous;

    @FXML
    private Button buttonLambda;

    @FXML
    private Button buttonFunctional;

    @FXML
    public void initialize() {
        // Anonymous Inner Class
        buttonAnonymous.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                System.out.println("Button clicked using anonymous inner class!");
            }
        });

        // Lambda Expression
        buttonLambda.setOnAction(event -> System.out.println("Button clicked using lambda expression!"));

        // Custom Functional Interface
        FunctionInterface action = () -> System.out.println("Button clicked using custom functional interface!");
        buttonFunctional.setOnAction(event -> action.execute());
    }
}
