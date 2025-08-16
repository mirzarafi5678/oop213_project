package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import java.io.Serializable;
import java.util.ArrayList;

public class PassengerData implements  Serializable {

    public String fullname;
        public  String bkashNumber;
        public String phoneNo;
        public String gender, typeOfSeat;
        public int needBaseCargoSpace, NumberOfTicket;
        public LaunchTrip obj= null;

        public boolean boughtticket= false;
        public boolean cancelticket = false;
        public boolean givefeedback= false;
        public int totalprice=0;

        public ArrayList<mvcOFsavePayment> ss= new ArrayList<>();


    public PassengerData(String fullname, LaunchTrip obj, int numberOfTicket, int needBaseCargoSpace,
                         String typeOfSeat, String gender, String phoneNo, String bkashNumber ) {


        this.fullname = fullname;
        this.obj = obj;
        NumberOfTicket = numberOfTicket;
        this.needBaseCargoSpace = needBaseCargoSpace;
        this.typeOfSeat = typeOfSeat;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.bkashNumber = bkashNumber;
    }



    public boolean isGivefeedback() {
        return givefeedback;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public void setGivefeedback(boolean givefeedback) {
        this.givefeedback = givefeedback;
    }

    public ArrayList<mvcOFsavePayment> getSave() {
        return ss;
    }

    public void add(mvcOFsavePayment savedata) {

        ss.add(savedata);
    }

    public LaunchTrip getObj() {
        return obj;
    }

    public void setObj(LaunchTrip obj) {
        this.obj = obj;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getNumberOfTicket() {
        return NumberOfTicket;
    }

    public void setNumberOfTicket(int numberOfTicket) {
        NumberOfTicket = numberOfTicket;
    }

    public int getNeedBaseCargoSpace() {
        return needBaseCargoSpace;
    }

    public void setNeedBaseCargoSpace(int needBaseCargoSpace) {
        this.needBaseCargoSpace = needBaseCargoSpace;
    }

    public String getTypeOfSeat() {
        return typeOfSeat;
    }

    public void setTypeOfSeat(String typeOfSeat) {
        this.typeOfSeat = typeOfSeat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getBkashNumber() {
        return bkashNumber;
    }

    public void setBkashNumber(String bkashNumber) {
        this.bkashNumber = bkashNumber;
    }

    public boolean isBoughtticket() {
        return boughtticket;
    }

    public void setBoughtticket(boolean boughtticket) {
        this.boughtticket = boughtticket;
    }

    public boolean isCancelticket() {
        return cancelticket;
    }

    public void setCancelticket(boolean cancelticket) {
        this.cancelticket = cancelticket;
    }

    @Override
    public String toString() {
        return "\n"+"PassengerData{" +
                "fullname='" + fullname + '\'' +
                ", bkashNumber='" + bkashNumber + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", gender='" + gender + '\'' +
                ", typeOfSeat='" + typeOfSeat + '\'' +
                ", needBaseCargoSpace=" + needBaseCargoSpace +
                ", NumberOfTicket=" + NumberOfTicket +
                ", obj=" + obj +

                ", boughtticket=" + boughtticket +
                ", cancelticket=" + cancelticket +
                ", givefeedback=" + givefeedback +
                ", totalprice=" + totalprice +
                '}';
    }


    public String style1() {
        return String.format(
                "\n---------------------------\n" +
                        "      PASSENGER DATA\n" +
                        "---------------------------\n" +
                        "Full Name       : %s%n" +
                        "bKash Number    : %s%n" +
                        "Phone No        : %s%n" +
                        "Gender          : %s%n" +
                        "Type of Seat    : %s%n" +
                        "Cargo Space     : %d%n" +
                        "No. of Tickets  : %d%n" +
                        "Launch Trip     : %s%n" +
                        "Bought Ticket   : %b%n" +
                        "Cancelled Ticket: %b%n" +
                        "Gave Feedback   : %b%n" +
                        "Total Price     : %d%n" +
                        "---------------------------",
                fullname, bkashNumber, phoneNo, gender, typeOfSeat,
                needBaseCargoSpace, NumberOfTicket,obj,
                boughtticket, cancelticket, givefeedback, totalprice
        );
    }
    public String style2() {
        String tripDetails = (obj != null)
                ? String.format(
                "  Trip Number    : %s%n" +
                        "  From           : %s%n" +
                        "  To             : %s%n" +
                        "  Start Time     : %s%n" +
                        "  Estimated Hour : %d%n" +
                        "  Price          : %d%n" +
                        "  Date           : %s%n",
                obj.tripnumber, obj.from, obj.to, obj.starttime,
                obj.estimatedhour, obj.price, obj.date
        )
                : "  No trip assigned%n";

        return String.format(
                "\n===========================\n" +
                        "      PASSENGER TICKET\n" +
                        "===========================\n" +
                        "Full Name       : %s%n" +
                        "bKash Number    : %s%n" +
                        "Phone No        : %s%n" +
                        "Gender          : %s%n" +
                        "Type of Seat    : %s%n" +
                        "Cargo Space     : %d%n" +
                        "No. of Tickets  : %d%n" +
                        "Bought Ticket   : %b%n" +
                        "Cancelled Ticket: %b%n" +
                        "Gave Feedback   : %b%n" +
                        "Total Price     : %d%n" +
                        "---------------------------\n" +
                        "   LAUNCH TRIP DETAILS\n" +
                        "---------------------------\n" +
                        "%s" +
                        "===========================",
                fullname, bkashNumber, phoneNo, gender, typeOfSeat,
                needBaseCargoSpace, NumberOfTicket,
                boughtticket, cancelticket, givefeedback, totalprice,
                tripDetails
        );
    }





}
