package com.example.project_individual;

import javafx.scene.control.DatePicker;
import java.io.Serializable;
import java.time.LocalDate;

public class Financial_Record implements Serializable, Report {
    private static final long serialVersionUID = 1L;

    public int add_Amount, Invest_amount, Revenue;
    public String purpose, Search_purpose;
    public LocalDate date;

    public Financial_Record(int add_Amount, int invest_amount, int revenue, String purpose, String search_purpose, LocalDate date) {
        this.add_Amount = add_Amount;
        Invest_amount = invest_amount;
        Revenue = revenue;
        this.purpose = purpose;
        Search_purpose = search_purpose;
        this.date = date;
    }

    public Financial_Record(int invest_amount, int add_Amount, int revenue) {
        Invest_amount = invest_amount;
        this.add_Amount = add_Amount;
        Revenue = revenue;
    }

    @Override
    public void prepareReport(){


    }

    public int getAdd_Amount() {
        return add_Amount;
    }

    public void setAdd_Amount(int add_Amount) {
        this.add_Amount = add_Amount;
    }

    public int getInvest_amount() {
        return Invest_amount;
    }

    public void setInvest_amount(int invest_amount) {
        Invest_amount = invest_amount;
    }

    public int getRevenue() {
        return Revenue;
    }

    public void setRevenue(int revenue) {
        Revenue = revenue;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getSearch_purpose() {
        return Search_purpose;
    }

    public void setSearch_purpose(String search_purpose) {
        Search_purpose = search_purpose;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Financial_Record{" +
                "add_Amount=" + add_Amount +
                ", Invest_amount=" + Invest_amount +
                ", Revenue=" + Revenue +
                ", purpose='" + purpose + '\'' +
                ", Search_purpose='" + Search_purpose + '\'' +
                ", date=" + date +
                '}';
    }
}