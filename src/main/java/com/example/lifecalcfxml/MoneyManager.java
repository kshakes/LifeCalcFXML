package com.example.lifecalcfxml;

public class MoneyManager {

    //Monthly living variables
    private double monthly;
    private double houseBudget;
    private double investmentAmount;

    //Car Variables
    private double carPrice;
    private double carBudget;

    public MoneyManager() {

    }

    public MoneyManager(double houseBudget, double carBudget) {
        this.houseBudget = houseBudget;
        this.carBudget = carBudget;
    }

    public double getmonthly() {
        return monthly;
    }
    public void setmonthly(double salary) {
        this.monthly = (double) Math.round((salary / 12) * 100) / 100;
    }

    public double getHouseBudget() {
        return houseBudget;
    }

    public void setHouseBudget() {
        this.houseBudget = (double) Math.round((monthly * 0.45) * 100) / 100;
    }

    public double getInvestmentAmount() {
        return investmentAmount;
    }

    public void setInvestmentAmount() {
        this.investmentAmount = (double) Math.round((monthly * 0.20) * 100) / 100;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carBudget) {
        this.carPrice = carBudget * ((1 - Math.pow(1 + 0.05, -36))) / 0.05;
    }

    public double getCarBudget() {
        return carBudget;
    }

    public void setCarBudget() {
        this.carBudget = (double) Math.round((monthly * 0.15) * 100) / 100;
    }

    public void setHouseBudget(double houseBudget) {
        this.houseBudget = houseBudget;
    }

    public void setCarBudget(double carBudget) {
        this.carBudget = carBudget;
    }
}
