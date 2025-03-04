package com.javaproject.hungrybarfinal.model;

public class CartItemModel{
    private int cartItemID;
    private int cartID;
    private int itemID;
    private int quantity;
    private String specialInstructions;

    public CartItemModel() {
    }

    public CartItemModel(int cartItemID, int cartID, int itemID, int quantity, String specialInstructions) {
        this.cartItemID = cartItemID;
        this.cartID = cartID;
        this.itemID = itemID;
        this.quantity = quantity;
        this.specialInstructions = specialInstructions;
    }

    public int getCartItemID() {
        return cartItemID;
    }

    public void setCartItemID(int cartItemID) {
        this.cartItemID = cartItemID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
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