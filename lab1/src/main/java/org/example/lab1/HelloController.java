package org.example.lab1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private RadioButton rdBRL,rdCAD,rdYEN;

    @FXML
    private ToggleGroup grCurrency;

    @FXML
    private TextArea result;

    @FXML
    private TextField usdValue;

    @FXML
    public void onConvertButtonClick(ActionEvent actionEvent) {
        double usdAmount = Double.parseDouble(usdValue.getText());
        double brl = 5.16 * usdAmount;
        double cad =1.37 * usdAmount;
        double yen =155.78 * usdAmount;
        String txtResult = "The result is: ";

        if (usdValue.getText().isEmpty()){
            result.setText("Please enter a valid USD amount");
            return;
        }

        if(rdBRL.isSelected()){
            result.setText(txtResult+"\n"+String.format("%.2f USD = %.2f BRL", usdAmount, brl));
        }
        if(rdCAD.isSelected()){
            result.setText(txtResult+"\n"+String.format("%.2f USD = %.2f CAD", usdAmount, cad));
        }
        if(rdYEN.isSelected()){
            result.setText(txtResult+"\n"+String.format("%.2f USD = %.2f YEN", usdAmount, yen));
        }


    }
}