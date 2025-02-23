package com.javaproject.hungrybarfinal.model;

public class DeliveryStaffModel {
    private String userID;
    private int assignedRestaurantID;
    private String vehicleDetails;

    public DeliveryStaffModel() {
    }

    public DeliveryStaffModel(String userID, int assignedRestaurantID, String vehicleDetails) {
        this.userID = userID;
        this.assignedRestaurantID = assignedRestaurantID;
        this.vehicleDetails = vehicleDetails;
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

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(String vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
    
    
}
