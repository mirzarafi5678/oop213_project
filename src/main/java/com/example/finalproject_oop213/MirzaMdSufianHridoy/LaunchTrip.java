package com.example.finalproject_oop213.MirzaMdSufianHridoy;

import java.io.Serializable;

public class LaunchTrip implements Serializable {

    public String tripnumber, from, to, starttime;
    public int estimatedhour, price;
    public String date;
//    public int trippassengerCount=0;


    public LaunchTrip(String tripnumber, String date, int price, int estimatedhour, String starttime,
                      String to, String from) {
        this.tripnumber = tripnumber;
        this.date = date;
        this.price = price;
        this.estimatedhour = estimatedhour;
        this.starttime = starttime;
        this.to = to;
        this.from = from;

    }



    public String getTripnumber() {
        return tripnumber;
    }

    public void setTripnumber(String tripnumber) {
        this.tripnumber = tripnumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEstimatedhour() {
        return estimatedhour;
    }

    public void setEstimatedhour(int estimatedhour) {
        this.estimatedhour = estimatedhour;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


    @Override
    public String toString() {
        return "LaunchTrip{" +
                "tripnumber='" + tripnumber + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", starttime='" + starttime + '\'' +
                ", estimatedhour=" + estimatedhour +
                ", price=" + price +
                ", date='" + date + '\'' +
                '}';
    }



    public String style1() {
        return String.format(
                "---------------------------%n" +
                        "       LAUNCH TICKET%n" +
                        "---------------------------%n" +
                        "Trip Number    : %s%n" +
                        "From           : %s%n" +
                        "To             : %s%n" +
                        "Start Time     : %s%n" +
                        "Estimated Hour : %d%n" +
                        "Price          : %d%n" +
                        "Date           : %s%n" +
                        "---------------------------",
                tripnumber, from, to, starttime, estimatedhour, price, date
        );
    }



}



