package com.example.tipidmate;

public class GroupBudget {

    private String title;
    private String subtitle;
    private String amount;
    private String status;
    private int progress;

    public GroupBudget(String title, String subtitle, String amount, String status, int progress) {
        this.title = title;
        this.subtitle = subtitle;
        this.amount = amount;
        this.status = status;
        this.progress = progress;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public int getProgress() {
        return progress;
    }
}
