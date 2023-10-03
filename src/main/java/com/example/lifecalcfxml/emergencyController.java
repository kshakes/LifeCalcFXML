package com.example.lifecalcfxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.InputMismatchException;

public class emergencyController {
    @FXML
    public Text showEmergencyFund;
    @FXML
    private TextField numOfMonthsField;

    static MoneyManager mm = new MoneyManager();

    public void calcEmergencyFund() {
         try{
             int monthsInput = Integer.parseInt(numOfMonthsField.getText());
             int currentMonth = 0;
             double goal = mm.getMoneyLeft() * monthsInput;
             double currentSaved = 0;

             showEmergencyFund.setText("Goal: £" + goal);

             while (currentSaved <= goal){
                 currentSaved += mm.getMoneyLeft();
                 currentMonth += 1;
                 showEmergencyFund.setText(showEmergencyFund.getText() + "\nMonth " + currentMonth + ": £" + currentSaved);
             }


         }catch (InputMismatchException e){
             System.out.println(e);
         }


    }
}
