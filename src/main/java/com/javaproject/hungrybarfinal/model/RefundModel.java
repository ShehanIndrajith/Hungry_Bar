package com.javaproject.hungrybarfinal.model;

public class RefundModel {
    private int refundID;
    private int orderID;
    private String requestedBy;
    private String processedBy;
    private double amount;
    private String status;
    private String reason;

    public RefundModel() {
    }

    public RefundModel(int refundID, int orderID, String requestedBy, String processedBy, double amount, String status, String reason) {
        this.refundID = refundID;
        this.orderID = orderID;
        this.requestedBy = requestedBy;
        this.processedBy = processedBy;
        this.amount = amount;
        this.status = status;
        this.reason = reason;
    }

    public int getRefundID() {
        return refundID;
    }

    public void setRefundID(int refundID) {
        this.refundID = refundID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
}
