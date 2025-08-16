package com.example.launchcompanysundarban.model;

import java.time.LocalDateTime;

public class Feedback {
    private final String id;
    private final String passengerName;
    private final String contactInfo;
    private final String message;
    private final LocalDateTime dateTime;
    private boolean replied;

    public Feedback(String id, String passengerName, String contactInfo, String message, LocalDateTime dateTime) {
        this.id = id;
        this.passengerName = passengerName;
        this.contactInfo = contactInfo;
        this.message = message;
        this.dateTime = dateTime;
        this.replied = false;
    }


    public Feedback(String passengerName, String message) {
        this("F" + System.currentTimeMillis(), passengerName, "", message, LocalDateTime.now());
    }

    public String getId() { return id; }
    public String getPassengerName() { return passengerName; }
    public String getContactInfo() { return contactInfo; }
    public String getMessage() { return message; }
    public LocalDateTime getDateTime() { return dateTime; }

    public boolean isReplied() { return replied; }
    public void setReplied(boolean replied) { this.replied = replied; }
}
