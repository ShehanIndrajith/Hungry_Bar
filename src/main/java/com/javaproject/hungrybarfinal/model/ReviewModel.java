package com.javaproject.hungrybarfinal.model;

import java.time.LocalDateTime;
public class ReviewModel {
    private int reviewID;
    private int orderID;
    private int foodRating;
    private int deliveryRating;
    private String comment;
    private LocalDateTime reviewDate;

    public ReviewModel() {
    }

    public ReviewModel(int reviewID, int orderID, int foodRating, int deliveryRating, String comment, LocalDateTime reviewDate) {
        this.reviewID = reviewID;
        this.orderID = orderID;
        this.foodRating = foodRating;
        this.deliveryRating = deliveryRating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(int foodRating) {
        this.foodRating = foodRating;
    }

    public int getDeliveryRating() {
        return deliveryRating;
    }

    public void setDeliveryRating(int deliveryRating) {
        this.deliveryRating = deliveryRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }
    
    
}
