package com.example.lifecalcfxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {
    @FXML
    private TextField salaryNum;
    @FXML
    private Text showInfo;

    static MoneyManager mm = new MoneyManager();

    public void calc() {
        if (!salaryNum.getText().equals("")){
            try{
                double salaryText = Double.parseDouble(salaryNum.getText());
                mm.setmonthly(salaryText);
                showInfo.setText("Monthly = £" + mm.getmonthly());
            } catch (NumberFormatException e){
                System.out.println(e);
            }
        }
    }
}