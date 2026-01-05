package com.example.tipidmate;

public class Goal {

    public String title;
    public String category;
    public double targetAmount;
    public double savedAmount;

    public Goal(String title, String category, double targetAmount) {
        this.title = title;
        this.category = category;
        this.targetAmount = targetAmount;
        this.savedAmount = 0;
    }

    public int getProgressPercent() {
        if (targetAmount == 0) return 0;
        return (int) ((savedAmount / targetAmount) * 100);
    }
}
