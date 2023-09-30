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
//              //Set the variables
                mm.setmonthly(salaryText);
                mm.setCarBudget();
                mm.setHouseCost();
                mm.setInvestmentAmount();

                showInfo.setVisible(true);
                showInfo.setText("Monthly = £" + mm.getmonthly() + "\n\nHouse Budget: £" +
                        mm.getHouseCost() + "\n\nCar Budget: £" + mm.getCarBudget() +
                        "\n\nInvestment Amount: £" + mm.getInvestmentAmount());
            } catch (NumberFormatException e){
                throw e;
            }
        }
    }
}