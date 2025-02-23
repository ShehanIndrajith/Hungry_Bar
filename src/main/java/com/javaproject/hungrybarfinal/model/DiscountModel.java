package com.javaproject.hungrybarfinal.model;

import java.time.LocalDateTime;
public class DiscountModel {
    private int discountID;
    private String code;
    private String discountType;
    private double value;
    private LocalDateTime validUntil;
    private int maxUses;
    private int restaurantID;

    public DiscountModel() {
    }

    public DiscountModel(int discountID, String code, String discountType, double value, LocalDateTime validUntil, int maxUses, int restaurantID) {
        this.discountID = discountID;
        this.code = code;
        this.discountType = discountType;
        this.value = value;
        this.validUntil = validUntil;
        this.maxUses = maxUses;
        this.restaurantID = restaurantID;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public int getMaxUses() {
        return maxUses;
    }

    public void setMaxUses(int maxUses) {
        this.maxUses = maxUses;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    
   
}
