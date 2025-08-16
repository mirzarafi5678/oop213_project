package com.example.project_individual;

import java.io.Serializable;
import java.time.LocalDate;

public class UtiliesExpense implements Serializable{
    private String utilitesType,paymentType;
    private int Amount;
    private LocalDate dateOfPayment;

    public UtiliesExpense(String utilitesType, String paymentType, int amount, LocalDate dateOfPayment) {
        this.utilitesType = utilitesType;
        this.paymentType = paymentType;
        Amount = amount;
        this.dateOfPayment = dateOfPayment;
    }

    public String getUtilitesType() {
        return utilitesType;
    }

    public void setUtilitesType(String utilitesType) {
        this.utilitesType = utilitesType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public LocalDate getDateOfPayment() {
        return dateOfPayment;
    }

    public void setDateOfPayment(LocalDate dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    @Override
    public String toString() {
        return "UtiliesExpense{" +
                "utilitesType='" + utilitesType + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", Amount=" + Amount +
                ", dateOfPayment=" + dateOfPayment +
                '}';
    }
}
