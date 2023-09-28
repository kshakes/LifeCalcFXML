package com.example.lifecalcfxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private TextField salaryNum;
    @FXML
    private Text showInfo;
    public void calc() {

        String salaryText = salaryNum.getText();

        float salary = Integer.parseInt(salaryText);

        showInfo.setText("Monthly = £" + salary/12f);
    }
}