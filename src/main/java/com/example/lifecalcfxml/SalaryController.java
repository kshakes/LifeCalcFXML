package com.example.lifecalcfxml;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.text.DecimalFormat;

public class SalaryController {
    @FXML
    private TextField salaryNum;
    @FXML
    private Text showInfo;
    @FXML
    private Button editDetailsButton;

    static MoneyManager mm = new MoneyManager();

    private double monthlyNet;
    private double carBudget;
    private double houseBudget;
    private double investmentAmount;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void calc() {
        if (!salaryNum.getText().isEmpty()){
            try{
                double salaryText = Double.parseDouble(salaryNum.getText());

                //Set the variables
                mm.setmonthly(salaryText);
                mm.setCarBudget();
                mm.setHouseCost();
                mm.setInvestmentAmount();

                setVars();

                showInfo.setVisible(true);
                editDetailsButton.setVisible(true);

                showInfo.setText("Monthly = £" + mm.getmonthly() + "\n\nHouse Budget: £" +
                        mm.getHouseCost() + "\n\nCar Budget: £" + mm.getCarBudget() +
                        "\n\nInvestment Amount: £" + mm.getInvestmentAmount() +
                        "\n\nMoney Left: £" + df.format(monthlyNet - carBudget - houseBudget - investmentAmount));
            } catch (NumberFormatException e){
                throw e;
            }
        }
    }

    public void setVars(){
        carBudget = mm.getCarBudget();
        houseBudget = mm.getHouseCost();
        investmentAmount = mm.getInvestmentAmount();
        monthlyNet = mm.getmonthly();
    }

    public void editDetails() {
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), editDetailsButton);
        transition.setToY(-50);
        transition.setAutoReverse(true);
        transition.play();
    }
}