package com.javaproject.hungrybarfinal.model;
import java.time.LocalDateTime;

public class InventoryRequestModel {
    private int requestID;
    private int inventoryID;
    private String requestedBy;
    private int quantityRequested;
    private String requestStatus;
    private LocalDateTime requestDate;

    public InventoryRequestModel() {
    }

    public InventoryRequestModel(int requestID, int inventoryID, String requestedBy, int quantityRequested, String requestStatus, LocalDateTime requestDate) {
        this.requestID = requestID;
        this.inventoryID = inventoryID;
        this.requestedBy = requestedBy;
        this.quantityRequested = quantityRequested;
        this.requestStatus = requestStatus;
        this.requestDate = requestDate;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public int getQuantityRequested() {
        return quantityRequested;
    }

    public void setQuantityRequested(int quantityRequested) {
        this.quantityRequested = quantityRequested;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    
}
