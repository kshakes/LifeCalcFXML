package com.example.lifecalcfxml;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class retirementController {

    @FXML
    private TextField ageTextField;

    final double averageReturn = 0.08 / 12;
    double initialBalance = 0;

    public void calcRetirement() {

        try{
            int userAge = Integer.parseInt((ageTextField.getText()));

            if (userAge >= 66){
                System.out.println("You are already at or above the retirement age");
            } else{

                int months = (66-userAge) * 12;
                System.out.println(months);

                for (int i = 1; i < months; i++){ //For every year in retirement age - years
                    //Do monthly compound interest
                    initialBalance = (initialBalance + SalaryController.investmentAmount) * (1 + averageReturn);
                    if (i % 12 == 0){
                        System.out.println("Year : " + i / 12 + " -> Balance: " + SalaryController.df.format(initialBalance));
                    }
                }
            }
        } catch (InputMismatchException e){
            throw e;
        }

    }
}
