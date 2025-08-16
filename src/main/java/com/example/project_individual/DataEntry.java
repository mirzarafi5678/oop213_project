package com.example.project_individual;

import java.io.Serializable;
import java.time.LocalDate;

public class DataEntry implements Serializable {
    private int ID,ProductAmount;
    private String Name,PurchaseProductName;
    private LocalDate PurchaseDate;

    public DataEntry(int ID, int productAmount, String name, String purchaseProductName, LocalDate purchaseDate) {
        this.ID = ID;
        ProductAmount = productAmount;
        Name = name;
        PurchaseProductName = purchaseProductName;
        PurchaseDate = purchaseDate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getProductAmount() {
        return ProductAmount;
    }

    public void setProductAmount(int productAmount) {
        ProductAmount = productAmount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPurchaseProductName() {
        return PurchaseProductName;
    }

    public void setPurchaseProductName(String purchaseProductName) {
        PurchaseProductName = purchaseProductName;
    }

    public LocalDate getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "DataEntry{" +
                "ID=" + ID +
                ", ProductAmount=" + ProductAmount +
                ", Name='" + Name + '\'' +
                ", PurchaseProductName='" + PurchaseProductName + '\'' +
                ", PurchaseDate=" + PurchaseDate +
                '}';
    }
}
