package com.example.lifecalcfxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class emergencyController {
    @FXML
    public Text showEmergencyFund;
    @FXML
    private TextField numOfMonthsField;

    private double spareMoney = SalaryController.moneyLeft + SalaryController.investmentAmount; // Money left after expenses (No investing during emergency fund creation)
    private double expenses = SalaryController.expenses;
    public void calcEmergencyFund() {

        int months = Integer.parseInt(numOfMonthsField.getText());
        if (months <= 0){
            showEmergencyFund.setText("Cannot set a value below 0");
        }else{
            showEmergencyFund.setText("");
            int currentMonth = 0;
            double goal = (expenses-SalaryController.investmentAmount) * months;
            double currentSaved = 0;

            showEmergencyFund.setText("Goal: £" + goal + "\n");

            while (currentSaved <= goal){
                currentSaved += spareMoney;
                currentMonth++;
                showEmergencyFund.setText(showEmergencyFund.getText() + "\nMonth " + currentMonth + ": " + SalaryController.currencyFormat.format(currentSaved));

            }
        }
    }
}
