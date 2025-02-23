package com.javaproject.hungrybarfinal.model;


public class InventoryModel {
    private int inventoryID;
    private int restaurantID;
    private String ingredientName;
    private int currentQuantity;
    private int minimumThreshold;

    public InventoryModel() {
    }

    public InventoryModel(int inventoryID, int restaurantID, String ingredientName, int currentQuantity, int minimumThreshold) {
        this.inventoryID = inventoryID;
        this.restaurantID = restaurantID;
        this.ingredientName = ingredientName;
        this.currentQuantity = currentQuantity;
        this.minimumThreshold = minimumThreshold;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getMinimumThreshold() {
        return minimumThreshold;
    }

    public void setMinimumThreshold(int minimumThreshold) {
        this.minimumThreshold = minimumThreshold;
    }
    
    
}
