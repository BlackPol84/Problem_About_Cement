package ru.ykul.service;

import java.time.LocalDateTime;

public class Order {
    private int amountOfCement;
    private LocalDateTime orderTime;
    private String company;
    public Order(LocalDateTime orderTime, String company, int amountOfCement) {
        this.orderTime = orderTime;
        this.company = company;
        this.amountOfCement = amountOfCement;
    }
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public int getAmountOfCement() {
        return amountOfCement;
    }
    public void setAmountOfCement(int amountOfCement) {
        this.amountOfCement = amountOfCement;
    }
}
