package com.javaproject.hungrybarfinal.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class OrderModel {
    private int orderID;
    private String customerID;
    private int restaurantID;
    private Timestamp orderDate;
    private double totalPrice;
    private String orderStatus;
    private String deliveryStaffID;
    private String deliveryAddress;
    private Timestamp estimatedDeliveryTime;
    private String paymentStatus;
    private List<OrderItemModel> items = new ArrayList<>();

    public OrderModel() {
    }

    public OrderModel(int orderID, String customerID, int restaurantID, Timestamp orderDate, double totalPrice, String orderStatus, String deliveryStaffID, String deliveryAddress, Timestamp estimatedDeliveryTime, String paymentStatus) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.restaurantID = restaurantID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.deliveryStaffID = deliveryStaffID;
        this.deliveryAddress = deliveryAddress;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public void addItem(OrderItemModel item) {
        this.items.add(item);
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

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
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

    public String getDeliveryStaffID() {
        return deliveryStaffID;
    }

    public void setDeliveryStaffID(String deliveryStaffID) {
        this.deliveryStaffID = deliveryStaffID;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Timestamp getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }

    public void setEstimatedDeliveryTime(Timestamp estimatedDeliveryTime) {
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<OrderItemModel> getItems() {
        return items;
    }

    public void setItems(List<OrderItemModel> items) {
        this.items = items;
    }

    
    
}
