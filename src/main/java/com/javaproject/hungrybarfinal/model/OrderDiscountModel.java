package com.javaproject.hungrybarfinal.model;


public class OrderDiscountModel {
    private int orderID;
    private int discountID;

    public OrderDiscountModel() {
    }

    public OrderDiscountModel(int orderID, int discountID) {
        this.orderID = orderID;
        this.discountID = discountID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }
    
    
}
