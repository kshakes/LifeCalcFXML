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

    public void calcEmergencyFund() {

        //Removed the code while i try and fix issues with it
        System.out.println(sC.moneyLeft);

    }
}
