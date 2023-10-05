package com.example.lifecalcfxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class emergencyController {
    @FXML
    public Text showEmergencyFund;
    @FXML
    private TextField numOfMonthsField;

    static SalaryController sC = new SalaryController();

    private final double spareMoney = SalaryController.moneyLeft;
    private final double expenses = SalaryController.expenses;

    public void calcEmergencyFund() {

        //Removed the code while I try and fix issues with it
        int months = Integer.parseInt(numOfMonthsField.getText());
        System.out.println(spareMoney * months);

    }
}
