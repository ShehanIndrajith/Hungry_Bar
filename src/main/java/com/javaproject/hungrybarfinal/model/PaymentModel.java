package com.javaproject.hungrybarfinal.model;

public class PaymentModel {
    private int paymentID;
    private int orderID;
    private double amount;
    private String method;
    private String status;
    private String transactionID;

    public PaymentModel() {
    }

    public PaymentModel(int paymentID, int orderID, double amount, String method, String status, String transactionID) {
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.transactionID = transactionID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
    
    
}
