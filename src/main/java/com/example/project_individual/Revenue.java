package com.example.project_individual;

import java.io.Serializable;
import java.time.LocalDate;

public class Revenue implements Serializable {
    public int Deposit,Revenue,Expense;
    public LocalDate Date;

    public Revenue(int deposit, int revenue, int expense, LocalDate date) {
        Deposit = deposit;
        Revenue = revenue;
        Expense = expense;
        Date = date;
    }

    public int getDeposit() {
        return Deposit;
    }

    public void setDeposit(int deposit) {
        Deposit = deposit;
    }

    public int getRevenue() {
        return Revenue;
    }

    public void setRevenue(int revenue) {
        Revenue = revenue;
    }

    public int getExpense() {
        return Expense;
    }

    public void setExpense(int expense) {
        Expense = expense;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    @Override
    public String toString() {
        return "Revenue{" +
                "Deposit=" + Deposit +
                ", Revenue=" + Revenue +
                ", Expense=" + Expense +
                ", Date=" + Date +
                '}';
    }
}
