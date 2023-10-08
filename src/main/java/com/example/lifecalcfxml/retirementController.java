package com.example.lifecalcfxml;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;

public class retirementController {

    @FXML
    private TextField ageTextField;
    @FXML
    private Text retirementText;

    final double averageReturn = 0.08 / 12;
    double initialBalance = 0;

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.UK);

    public void calcRetirement() {

        try{
            int userAge = Integer.parseInt((ageTextField.getText()));

            if (userAge >= 66){
                retirementText.setText("You are already at or above the retirement age");
            } else if (userAge <= 0){
                retirementText.setText("Invalid Age");
            }
            else{
                retirementText.setText("");
                int months = (66-userAge) * 12;

                for (int i = 1; i < months; i++){ //For every year in retirement age - years
                    //Do monthly compound interest
                    initialBalance = (initialBalance + SalaryController.investmentAmount) * (1 + averageReturn);
                    if (i % 12 == 0){
                        retirementText.setText(retirementText.getText() + "Age : " + (userAge + i / 12) + " -> Balance: " + currencyFormat.format(initialBalance) + "\n"); //SalaryController.df.format(initialBalance)
                    }
                }
            }
        } catch (InputMismatchException e){
            throw e;
        }

    }
}
