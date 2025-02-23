package com.javaproject.hungrybarfinal.model;


public class AdminModel {
    private String userID;

    public AdminModel() {
    }

    public AdminModel(String userID) {
        this.userID = userID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    
}
