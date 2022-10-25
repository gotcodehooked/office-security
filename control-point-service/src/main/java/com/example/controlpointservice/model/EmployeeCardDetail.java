package com.example.controlpointservice.model;

public class EmployeeCardDetail {

    private String uuid;
    private String fistName;
    private String lastName;
    private String userID;

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public EmployeeCardDetail() {
    }

    public void setUUID(String UUID) {
        this.uuid = UUID;
    }

    public String getUUID() {
        return uuid;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserID() {
        return userID;
    }
}
