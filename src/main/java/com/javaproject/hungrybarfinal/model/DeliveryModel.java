package com.javaproject.hungrybarfinal.model;

import java.time.LocalDateTime;
public class DeliveryModel {
    private int deliveryID;
    private int orderID;
    private String deliveryStaffID;
    private LocalDateTime pickupTime;
    private LocalDateTime deliveryTime;
    private String deliveryStatus;
    private String deliveryNotes;

    public DeliveryModel() {
    }

    public DeliveryModel(int deliveryID, int orderID, String deliveryStaffID, LocalDateTime pickupTime, LocalDateTime deliveryTime, String deliveryStatus, String deliveryNotes) {
        this.deliveryID = deliveryID;
        this.orderID = orderID;
        this.deliveryStaffID = deliveryStaffID;
        this.pickupTime = pickupTime;
        this.deliveryTime = deliveryTime;
        this.deliveryStatus = deliveryStatus;
        this.deliveryNotes = deliveryNotes;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getDeliveryStaffID() {
        return deliveryStaffID;
    }

    public void setDeliveryStaffID(String deliveryStaffID) {
        this.deliveryStaffID = deliveryStaffID;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getDeliveryNotes() {
        return deliveryNotes;
    }

    public void setDeliveryNotes(String deliveryNotes) {
        this.deliveryNotes = deliveryNotes;
    }
    
    
}
