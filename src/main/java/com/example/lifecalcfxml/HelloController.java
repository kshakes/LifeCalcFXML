package com.example.lifecalcfxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class HelloController {
    @FXML
    private TextField salaryNum;
    @FXML
    private Text showInfo;

    static MoneyManager mm = new MoneyManager();

    private double monthlyNet;
    private double carBudget;
    private double houseBudget;
    private double investmentAmount;

    private static DecimalFormat df = new DecimalFormat("0.00");

    public void calc() {
        if (!salaryNum.getText().equals("")){
            try{
                double salaryText = Double.parseDouble(salaryNum.getText());

                //Set the variables
                mm.setmonthly(salaryText);
                mm.setCarBudget();
                mm.setHouseCost();
                mm.setInvestmentAmount();

                setVars();



                showInfo.setVisible(true);
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
}