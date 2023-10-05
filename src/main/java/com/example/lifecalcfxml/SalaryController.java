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
    //Variables for Edit Details section
    @FXML
    private HBox editFieldHBox;
    @FXML
    private TextField budgetTypeField;
    @FXML
    private Text budgetTypeText;
    @FXML
    private Button editDetailsButton;
    //Variables for inputting the salary and showing the calculations
    @FXML
    private TextField salaryNum;
    @FXML
    private Text showInfo;

    static MoneyManager mm = new MoneyManager();

    //Variables that are a part of showInfo
    private double monthlyNet;
    private double carBudget;
    private double houseBudget;
    static double investmentAmount;
    //public double moneyLeft = monthlyNet - carBudget - houseBudget - investmentAmount;
    static double moneyLeft;
    static double expenses;

    //Helps with formatting and not having .000000000000
    private static final DecimalFormat df = new DecimalFormat("0.00");
    //Key with determining whether the carBudget/houseBudget input field should be visible and determines
    //Animations that should be played to put it back to its original state
    private boolean isEdited = false;

    public void calc() {

        //Implement a script that makes the emergency fund button and the retirement fund button
        //visible when the user enters this part of the program

        //Animation settings to fade the showInfo. Creates a smoother UI and better user experience
        FadeTransition fadeInTransitionField = new FadeTransition(Duration.seconds(0.5), showInfo);
        fadeInTransitionField.setFromValue(0.0);
        fadeInTransitionField.setToValue(1.0);

        //If the salaryNum box isn't empty, then check if it isn't on the phase of having car/house budget edited
        //If it isn't, then allow all the values to be calculated purely from the salary
        //If it is being edited, then just display the values
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
                fadeInTransitionField.play();

                showInfo.setText("Monthly = £" + mm.getmonthly() + "\n\nHouse Budget: £" +
                        mm.getHouseBudget() + "\n\nCar Budget: £" + mm.getCarBudget() +
                        "\n\nInvestment Amount: £" + mm.getInvestmentAmount() +
                        "\n\nMoney Left: £" + df.format(monthlyNet - carBudget - houseBudget - investmentAmount));
            } catch (NumberFormatException e){ //Make sure there is only numbers input
                System.out.println(e);
            }
        }
    }

    public void setVars(){
        if (!isEdited){
            mm.setCarBudget();
            mm.setHouseBudget();
        }
        monthlyNet = mm.getmonthly();
        mm.setInvestmentAmount();
        carBudget = mm.getCarBudget();
        houseBudget = mm.getHouseBudget();
        investmentAmount = mm.getInvestmentAmount();
        expenses = carBudget + houseBudget + investmentAmount;
        moneyLeft = monthlyNet - (carBudget + houseBudget + investmentAmount);
    }

    public void editDetails() {
        //Animation in order to provide a more interactive experience for the user
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), editDetailsButton);
        FadeTransition fadeInTransitionField = new FadeTransition(Duration.seconds(1), editFieldHBox);

        if (!isEdited){
            transition.setToY(-30);
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
        }
        else{ //Resets the animation after the user has edited the car and house budget
            transition.setToY(0);
            transition.play();

            editFieldHBox.setVisible(false);
            isEdited = false;
        }
    }
    public void editDetailsConfirm(KeyEvent key) {
        try{
            if (key.getCode() == KeyCode.ENTER){ // If the user clicks the Enter key
                String checkText = budgetTypeText.getText(); // Get whatever is in the box (ints only)
                //In order for this section to work, I figured the easiest way is to check that the text = the section you edit
                //and then change it once it's edited. I found it a lot easier to track when things are edited and the code
                //is readable
                if (checkText.contains("Car Budget:")){
                    carBudget = Double.parseDouble(budgetTypeField.getText());
                    mm.setCarBudget(carBudget);
                    budgetTypeField.clear(); //Clear it so the user doesn't have to remove their previous input
                    budgetTypeText.setText("House Budget:");
                    isEdited = true;
                }
                else{
                    houseBudget = Double.parseDouble(budgetTypeField.getText());
                    mm.setHouseBudget(houseBudget);
                    budgetTypeText.setText("Car Budget:");
                    budgetTypeField.clear(); //Clear it so the user doesn't have to remove their previous input
                    calc();
                    editDetails();
                }
            }
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }


    }
}