package com.javaproject.hungrybarfinal.model;

import java.time.LocalDateTime;
public class OrderModel {
    private int orderID;
    private String customerID;
    private int restaurantID;
    private LocalDateTime orderDate;
    private double totalPrice;
    private String orderStatus;
    private String deliveryAddress;

    public OrderModel() {
    }

    public OrderModel(int orderID, String customerID, int restaurantID, LocalDateTime orderDate, double totalPrice, String orderStatus, String deliveryAddress) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.restaurantID = restaurantID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    
}
