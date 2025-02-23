package com.javaproject.hungrybarfinal.model;

public class ManagerModel {
    private String userID;
    private int managedRestaurantID;

    public ManagerModel() {
    }

    public ManagerModel(String userID, int managedRestaurantID) {
        this.userID = userID;
        this.managedRestaurantID = managedRestaurantID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getManagedRestaurantID() {
        return managedRestaurantID;
    }

    public void setManagedRestaurantID(int managedRestaurantID) {
        this.managedRestaurantID = managedRestaurantID;
    }
    
    
}
