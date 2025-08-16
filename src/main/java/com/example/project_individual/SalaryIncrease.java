package com.example.project_individual;

import java.io.Serializable;

public class SalaryIncrease implements Serializable {
    private int ID;
    private double salary;
    private String Name;


    public SalaryIncrease(int ID, double salary, String name) {
        this.ID = ID;
        this.salary = salary;
        Name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "SalaryIncrease{" +
                "ID=" + ID +
                ", salary=" + salary +
                ", Name='" + Name + '\'' +
                '}';
    }
}
