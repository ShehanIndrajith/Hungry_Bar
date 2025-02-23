package com.javaproject.hungrybarfinal.model;

public class OrderItemModel {
    private int orderItemID;
    private int orderID;
    private int itemID;
    private int quantity;
    private String specialInstructions;

    public OrderItemModel() {
    }

    public OrderItemModel(int orderItemID, int orderID, int itemID, int quantity, String specialInstructions) {
        this.orderItemID = orderItemID;
        this.orderID = orderID;
        this.itemID = itemID;
        this.quantity = quantity;
        this.specialInstructions = specialInstructions;
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
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
