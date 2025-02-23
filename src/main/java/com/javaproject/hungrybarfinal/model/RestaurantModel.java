package com.javaproject.hungrybarfinal.model;

public class RestaurantModel {
    private int restaurantID;
    private String name;
    private String location;
    private String contactNumber;
    private String managerID;

    public RestaurantModel() {
    }

    public RestaurantModel(int restaurantID, String name, String location, String contactNumber, String managerID) {
        this.restaurantID = restaurantID;
        this.name = name;
        this.location = location;
        this.contactNumber = contactNumber;
        this.managerID = managerID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getManagerID() {
        return managerID;
    }

    public void setManagerID(String managerID) {
        this.managerID = managerID;
    }
    
    
}
