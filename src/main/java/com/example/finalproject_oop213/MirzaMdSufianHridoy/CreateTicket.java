package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import java.io.Serializable;

public class CreateTicket implements Serializable {
    public String  nametf,tripnumber,gender,seattype;
    public  int setid,cargosapce,numberofseat,contactnumber;
    public LaunchTrip obj=null;
    public int yourtotalprice=0;

    public CreateTicket(String nametf, LaunchTrip obj, int contactnumber, int numberofseat, int cargosapce,
                        int setid, String seattype, String gender, String tripnumber) {
        this.nametf = nametf;
        this.obj = obj;
        this.contactnumber = contactnumber;
        this.numberofseat = numberofseat;
        this.cargosapce = cargosapce;
        this.setid = setid;
        this.seattype = seattype;
        this.gender = gender;
        this.tripnumber = tripnumber;
    }

    public int getYourtotalprice() {
        return yourtotalprice;
    }



    public void bigprice(int yourtotalprice) {
        this.yourtotalprice += yourtotalprice;
    }

    public String getNametf() {
        return nametf;
    }

    public void setNametf(String nametf) {
        this.nametf = nametf;
    }

    public LaunchTrip getObj() {
        return obj;
    }

    public void setObj(LaunchTrip obj) {
        this.obj = obj;
    }

    public int getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(int contactnumber) {
        this.contactnumber = contactnumber;
    }

    public int getNumberofseat() {
        return numberofseat;
    }

    public void setNumberofseat(int numberofseat) {
        this.numberofseat = numberofseat;
    }

    public int getCargosapce() {
        return cargosapce;
    }

    public void setCargosapce(int cargosapce) {
        this.cargosapce = cargosapce;
    }

    public int getSetid() {
        return setid;
    }

    public void setSetid(int setid) {
        this.setid = setid;
    }

    public String getSeattype() {
        return seattype;
    }

    public void setSeattype(String seattype) {
        this.seattype = seattype;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTripnumber() {
        return tripnumber;
    }

    public void setTripnumber(String tripnumber) {
        this.tripnumber = tripnumber;
    }
//   "\n"
    @Override
    public String toString() {
        String tripDetails = (obj != null)
                ? String.format(
                "Trip: %s | %s → %s | Start: %s | Hrs: %d | Price: %d | Date: %s",
                obj.tripnumber, obj.from, obj.to, obj.starttime,
                obj.estimatedhour, obj.price, obj.date
        )
                : "No trip assigned";

        return String.format(
                "Name: %s | Gender: %s | Seat: %s (%d) | Cargo: %d | Seats: %d | Contact: %d | Total: %d%n  %s%n",
                nametf, gender, seattype, setid, cargosapce, numberofseat,
                contactnumber, yourtotalprice, tripDetails
        );
    }

//    public String style1() {
//        String tripDetails = (obj != null)
//                ? String.format(
//                "Trip: %s | %s → %s | Start: %s | Hrs: %d | Price: %d | Date: %s",
//                obj.tripnumber, obj.from, obj.to, obj.starttime,
//                obj.estimatedhour, obj.price, obj.date
//        )
//                : "No trip assigned";
//
//        return String.format(
//                "Name: %s | Gender: %s | Seat: %s (%d) | Cargo: %d | Seats: %d | Contact: %d | Total: %d%n  %s%n",
//                nametf, gender, seattype, setid, cargosapce, numberofseat,
//                contactnumber, yourtotalprice, tripDetails
//        );
//    }


}
