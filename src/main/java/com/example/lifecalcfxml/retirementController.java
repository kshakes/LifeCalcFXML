package com.example.lifecalcfxml;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;

public class retirementController {

    @FXML
    private TextField ageTextField;

    final int retirementAge = 66;

    public void calcRetirement() {
        try{
            int userAge = Integer.parseInt((ageTextField.getText()));
            if (userAge >= 66){
                System.out.println("You are already at or above the retirement age");
            }
            System.out.println(userAge);

        } catch (InputMismatchException e){
            throw e;
        }

    }
}
