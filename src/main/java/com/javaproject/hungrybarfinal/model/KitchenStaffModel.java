package com.javaproject.hungrybarfinal.model;

public class KitchenStaffModel {
    private String userID;
    private int assignedRestaurantID;

    public KitchenStaffModel() {
    }

    public KitchenStaffModel(String userID, int assignedRestaurantID) {
        this.userID = userID;
        this.assignedRestaurantID = assignedRestaurantID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getAssignedRestaurantID() {
        return assignedRestaurantID;
    }

    public void setAssignedRestaurantID(int assignedRestaurantID) {
        this.assignedRestaurantID = assignedRestaurantID;
    }
    
    
}
