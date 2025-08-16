package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import java.io.Serializable;

public class NoticeMvc implements Serializable {
    public int count =0;
    public String str="";

    public NoticeMvc(int count, String str) {
        this.count = count;
        this.str = str;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    @Override
    public String toString() {
        return str ;
    }
}
