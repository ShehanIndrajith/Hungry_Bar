package com.javaproject.hungrybarfinal.model;

public class OrderItemModel {
    private int itemID;
    private int quantity;
    private String specialInstructions;

    public OrderItemModel() {
    }

    public OrderItemModel(int itemID, int quantity, String specialInstructions) {
        this.itemID = itemID;
        this.quantity = quantity;
        this.specialInstructions = specialInstructions;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

   
    
}
