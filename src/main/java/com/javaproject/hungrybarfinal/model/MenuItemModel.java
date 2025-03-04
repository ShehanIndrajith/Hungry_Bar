package com.javaproject.hungrybarfinal.model;

public class MenuItemModel {
    private int itemID;
    private String name;
    private String description;
    private double price;
    private int categoryID;
    private String itemType;
    private boolean isCustomizable;
    private boolean available;
    private String imageURL;
    private int restaurantID;

    public MenuItemModel() {
    }

    public MenuItemModel(int itemID, String name, String description, double price, int categoryID, String itemType, boolean isCustomizable, boolean available, String imageURL, int restaurantID) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryID = categoryID;
        this.itemType = itemType;
        this.isCustomizable = isCustomizable;
        this.available = available;
        this.imageURL = imageURL;
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

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public boolean isIsCustomizable() {
        return isCustomizable;
    }

    public void setIsCustomizable(boolean isCustomizable) {
        this.isCustomizable = isCustomizable;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

   
}
