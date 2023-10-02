package com.example.lifecalcfxml;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.text.DecimalFormat;

public class SalaryController {
    @FXML
    private HBox editFieldHBox;
    @FXML
    private TextField budgetTypeField;
    @FXML
    private Text budgetTypeText;

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

    private boolean isEdited = false;

    public void calc() {
        if (!salaryNum.getText().isEmpty()){
            try{
                if (!isEdited){
                    double salaryText = Double.parseDouble(salaryNum.getText());
                    //Set the variables
                    mm.setmonthly(salaryText);
                    setVars();
                    showInfo.setVisible(true);
                    editDetailsButton.setVisible(true);
                }

                showInfo.setText("Monthly = £" + mm.getmonthly() + "\n\nHouse Budget: £" +
                        mm.getHouseBudget() + "\n\nCar Budget: £" + mm.getCarBudget() +
                        "\n\nInvestment Amount: £" + mm.getInvestmentAmount() +
                        "\n\nMoney Left: £" + df.format(monthlyNet - carBudget - houseBudget - investmentAmount));
            } catch (NumberFormatException e){
                throw e;
            }
        }
    }

    public void setVars(){
        mm.setCarBudget();
        mm.setHouseBudget();
        mm.setInvestmentAmount();
        carBudget = mm.getCarBudget();
        houseBudget = mm.getHouseBudget();
        investmentAmount = mm.getInvestmentAmount();
        monthlyNet = mm.getmonthly();
    }

    public void editDetails() {
        //Animation in order to provide a more interactive experience for the user
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), editDetailsButton);
        FadeTransition fadeInTransitionField = new FadeTransition(Duration.seconds(1), editFieldHBox);

        if (!isEdited){
            transition.setToY(-60);
            transition.setAutoReverse(true);
            transition.play();

            //Fades both the TextField and the Text
            fadeInTransitionField.setFromValue(0.0);
            fadeInTransitionField.setToValue(1.0);
            fadeInTransitionField.play();

            fadeInTransitionField.setFromValue(0.0);
            fadeInTransitionField.setToValue(1.0);
            fadeInTransitionField.play();
            editFieldHBox.setVisible(true);
            isEdited = true;
        }
        else{
            transition.setToY(0);
            transition.play();

            editFieldHBox.setVisible(false);
            isEdited = false;
        }
    }
    public void editDetailsConfirm(KeyEvent key) {
        try{
            if (key.getCode() == KeyCode.ENTER){
                String checkText = budgetTypeText.getText();
                if (checkText.contains("Car Budget:")){
                    carBudget = Double.parseDouble(budgetTypeField.getText());
                    System.out.println("Car Budget: " + carBudget);
                    budgetTypeText.setText("House Budget:");
                    isEdited = true;
                }
                else{
                    houseBudget = Double.parseDouble(budgetTypeField.getText());
                    System.out.println("House Budget: " + houseBudget);
                    budgetTypeText.setText("Car Budget:");
                    calc();
                    editDetails();
                }
            }
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }


    }
}