package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import java.io.Serializable;
import java.util.ArrayList;

public class alluserdata implements Serializable {
    private String setUsername;
    private String setpassword;
    private String setusertype;
    public PassengerData pass=null;




    public alluserdata(String setpassword, String setusertype, String setUsername) {
        this.setpassword = setpassword;

        this.setusertype = setusertype;
        this.setUsername = setUsername;
    }


    public PassengerData getPass() {
        return pass;
    }

    public void setPass(PassengerData pass) {
        this.pass = pass;
    }

    public String getSetUsername() {
        return setUsername;
    }

    public void setSetUsername(String setUsername) {
        this.setUsername = setUsername;
    }





    public String getSetusertype() {
        return setusertype;
    }

    public void setSetusertype(String setusertype) {
        this.setusertype = setusertype;
    }

    public String getSetpassword() {
        return setpassword;
    }

    public void setSetpassword(String setpassword) {
        this.setpassword = setpassword;
    }




}

