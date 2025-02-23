package com.javaproject.hungrybarfinal.model;

public class CustomerModel {
    private String userID;
    private String phoneNumber;
    private String address;
    private String paymentDetails;
    private boolean profileCompleted;

    public CustomerModel() {
    }

    public CustomerModel(String userID, String phoneNumber, String address, String paymentDetails, boolean profileCompleted) {
        this.userID = userID;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.paymentDetails = paymentDetails;
        this.profileCompleted = profileCompleted;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public boolean isProfileCompleted() {
        return profileCompleted;
    }

    public void setProfileCompleted(boolean profileCompleted) {
        this.profileCompleted = profileCompleted;
    }
    
    
}
