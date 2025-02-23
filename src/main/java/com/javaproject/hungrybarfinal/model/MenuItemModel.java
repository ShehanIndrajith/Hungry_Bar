package com.javaproject.hungrybarfinal.model;

public class MenuItemModel {
    private int itemID;
    private String name;
    private String description;
    private double price;
    private String category;
    private int restaurantID;

    public MenuItemModel() {
    }

    public MenuItemModel(int itemID, String name, String description, double price, String category, int restaurantID) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.restaurantID = restaurantID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }
    
    
}
