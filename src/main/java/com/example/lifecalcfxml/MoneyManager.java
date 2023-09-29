package com.example.lifecalcfxml;

public class MoneyManager {

    private double monthly;

    public MoneyManager() {

    }

    public double getmonthly() {
        return monthly;
    }

    public void setmonthly(double salary) {
        this.monthly = (double) Math.round((salary / 12) * 100) / 100;
    }
}
