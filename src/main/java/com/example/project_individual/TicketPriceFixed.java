package com.example.project_individual;

import java.io.Serializable;

public class TicketPriceFixed implements Serializable {
      private int ID,amount;
      private  String From,To,Category;

    public TicketPriceFixed(int ID, int amount, String from, String to, String category) {
        this.ID = ID;
        this.amount = amount;
        From = from;
        To = to;
        Category = category;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getFrom() {
        return From;
    }

    public void setFrom(String from) {
        From = from;
    }

    public String getTo() {
        return To;
    }

    public void setTo(String to) {
        To = to;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    @Override
    public String toString() {
        return "TicketPriceFixed{" +
                "ID=" + ID +
                ", amount=" + amount +
                ", From='" + From + '\'' +
                ", To='" + To + '\'' +
                ", Category='" + Category + '\'' +
                '}';
    }
}
