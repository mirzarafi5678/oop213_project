package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import java.io.Serializable;
import java.time.LocalDate;

public class mvcOFsavePayment implements Serializable  {
    public String holdername;
    public String nameofbanksystem;
    public LocalDate expirydate;
    public String numberorcardnum;
    public String banktype;

    public mvcOFsavePayment(String holdername, String banktype, String numberorcardnum, LocalDate expirydate, String nameofbanksystem) {
        this.holdername = holdername;
        this.banktype = banktype;
        this.numberorcardnum = numberorcardnum;
        this.expirydate = expirydate;
        this.nameofbanksystem = nameofbanksystem;
    }

    public String getHoldername() {
        return holdername;
    }

    public void setHoldername(String holdername) {
        this.holdername = holdername;
    }

    public String getBanktype() {
        return banktype;
    }

    public void setBanktype(String banktype) {
        this.banktype = banktype;
    }

    public String getNumberorcardnum() {
        return numberorcardnum;
    }

    public void setNumberorcardnum(String numberorcardnum) {
        this.numberorcardnum = numberorcardnum;
    }

    public LocalDate getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(LocalDate expirydate) {
        this.expirydate = expirydate;
    }

    public String getNameofbanksystem() {
        return nameofbanksystem;
    }

    public void setNameofbanksystem(String nameofbanksystem) {
        this.nameofbanksystem = nameofbanksystem;
    }
}
