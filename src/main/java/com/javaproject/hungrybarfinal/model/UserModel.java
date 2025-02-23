package com.javaproject.hungrybarfinal.model;
import java.time.LocalDateTime;

public class UserModel {
    private String userID;
    private String name;
    private String email;
    private String password;
    private String role;
    private String authProvider;
    private String profilePicture;
    private LocalDateTime createdAt;

    public UserModel() {
    }

    public UserModel(String userID, String name, String email, String password, String role, String authProvider, String profilePicture, LocalDateTime createdAt) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.authProvider = authProvider;
        this.profilePicture = profilePicture;
        this.createdAt = createdAt;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthProvider() {
        return authProvider;
    }

    public void setAuthProvider(String authProvider) {
        this.authProvider = authProvider;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    
}
