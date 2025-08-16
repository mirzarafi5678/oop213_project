package com.example.project_individual;

import java.io.Serializable;
import java.time.LocalDate;

public class CallRecord implements Serializable,Report{
    public void prepareReport(){

    }

    private int CallerID;
    private String CallerName,CallDetails,CallerEmailID,Emergency,CallType;
    private LocalDate CallDate;

    public CallRecord(int callerID, String callerName, String callDetails, String callerEmailID, String emergency, String callType, LocalDate callDate) {
        CallerID = callerID;
        CallerName = callerName;
        CallDetails = callDetails;
        CallerEmailID = callerEmailID;
        Emergency = emergency;
        CallType = callType;
        CallDate = callDate;
    }

    public int getCallerID() {
        return CallerID;
    }

    public void setCallerID(int callerID) {
        CallerID = callerID;
    }

    public String getCallerName() {
        return CallerName;
    }

    public void setCallerName(String callerName) {
        CallerName = callerName;
    }

    public String getCallDetails() {
        return CallDetails;
    }

    public void setCallDetails(String callDetails) {
        CallDetails = callDetails;
    }

    public String getCallerEmailID() {
        return CallerEmailID;
    }

    public void setCallerEmailID(String callerEmailID) {
        CallerEmailID = callerEmailID;
    }

    public String getEmergency() {
        return Emergency;
    }

    public void setEmergency(String emergency) {
        Emergency = emergency;
    }

    public String getCallType() {
        return CallType;
    }

    public void setCallType(String callType) {
        CallType = callType;
    }

    public LocalDate getCallDate() {
        return CallDate;
    }

    public void setCallDate(LocalDate callDate) {
        CallDate = callDate;
    }

    @Override
    public String toString() {
        return "CallRecord{" +
                "CallerID=" + CallerID +
                ", CallerName='" + CallerName + '\'' +
                ", CallDetails='" + CallDetails + '\'' +
                ", CallerEmailID='" + CallerEmailID + '\'' +
                ", Emergency='" + Emergency + '\'' +
                ", CallType='" + CallType + '\'' +
                ", CallDate=" + CallDate +
                '}';
    }
}
