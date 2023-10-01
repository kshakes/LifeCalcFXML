package com.example.lifecalcfxml;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private TextField editDetailsField;
    @FXML
    private Text editDetailsText;

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
        //Animation in order to provide a more interactive experience for the user
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), editDetailsButton);
        transition.setToY(-60);
        transition.setAutoReverse(true);
        transition.play();

        editDetailsField.setVisible(true);
        editDetailsText.setVisible(true);

        //Fades both the TextField and the Text
        FadeTransition fadeInTransitionField = new FadeTransition(Duration.seconds(1), editDetailsField);
        fadeInTransitionField.setFromValue(0.0);
        fadeInTransitionField.setToValue(1.0);
        fadeInTransitionField.play();

        FadeTransition fadeInTransitionText = new FadeTransition(Duration.seconds(1), editDetailsText);
        fadeInTransitionText.setFromValue(0.0);
        fadeInTransitionText.setToValue(1.0);
        fadeInTransitionText.play();
    }

    public void editDetailsConfirm(KeyEvent keyEvent) {
        MoneyManager mmEdited = new MoneyManager();
        for (int i = 0; i <= 2; i++)
            //FINISH LATER
        if (keyEvent.getCode() == KeyCode.SPACE){

        }
    }
}