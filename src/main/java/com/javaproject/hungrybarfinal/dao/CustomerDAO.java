package com.javaproject.hungrybarfinal.dao;
import com.javaproject.hungrybarfinal.model.UserModel;
import com.javaproject.hungrybarfinal.model.ProfileModel;
import com.javaproject.hungrybarfinal.model.CustomerModel;
import com.javaproject.hungrybarfinal.config.DBConfiguration;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {
    private static final String REGISTER_CUSTOMER= "INSERT INTO User (UserID, Name, Email, Password,Role) VALUES (?,?,?,?,?);";
    public String registerUser(UserModel user) throws SQLException{
        String generatedUserID = null;
        try (Connection connection = DBConfiguration.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_CUSTOMER, PreparedStatement.RETURN_GENERATED_KEYS)){
            generatedUserID = generateCustomUserID(connection, "CUS-");
            
            preparedStatement.setString(1, generatedUserID);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, "Customer");
            preparedStatement.executeUpdate();
        }
        return generatedUserID;
    }
    
    private String generateCustomUserID(Connection conn, String prefix) throws SQLException {
        String query = "SELECT MAX(CAST(SUBSTRING(UserID, LENGTH(?) + 1) AS UNSIGNED)) + 1 AS nextNumber FROM User WHERE UserID LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, prefix);
            pstmt.setString(2, prefix + "%");

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int nextNumber = rs.getInt("nextNumber");
                return prefix + String.format("%08d", nextNumber); // Format as CUS-00000001
            } else {
                return prefix + "00000001"; // Start from 1 if no records exist
            }
        }
    }
    
    // Authenticate user by email and password
    public UserModel authenticateUser(String email, String password) throws SQLException {
        String query = "SELECT * FROM User WHERE Email = ? AND Password = ?";
        UserModel user = null;

        try (Connection conn = DBConfiguration.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.setUserID(rs.getString("UserID"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setRole(rs.getString("Role"));
            }
        }

        return user;
    }
    
    // Fetch user and customer details by UserID
    public UserModel getUserDetails(String userID) throws SQLException {
        String query = "SELECT * FROM User WHERE UserID = ?";
        UserModel user = null;

        try (Connection conn = DBConfiguration.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new UserModel();
                user.setUserID(rs.getString("UserID"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setProfilePicture(rs.getString("ProfilePicture"));
            }
        }

        return user;
    }

    // Fetch customer details by UserID
    public CustomerModel getCustomerDetails(String userID) throws SQLException {
        String query = "SELECT * FROM Customer WHERE UserID = ?";
        CustomerModel customer = null;

        try (Connection conn = DBConfiguration.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                customer = new CustomerModel();
                customer.setUserID(rs.getString("UserID"));
                customer.setPhoneNumber(rs.getString("PhoneNumber"));
                customer.setAddress(rs.getString("Address"));
                customer.setPaymentDetails(rs.getString("PaymentDetails"));
                customer.setProfileCompleted(rs.getBoolean("ProfileCompleted"));
            }
        }

        return customer;
    }
    // Fetch profile details by UserID
    public ProfileModel getProfileDetails(String userID) throws SQLException {
        String query = "SELECT u.UserID, u.Name, u.Email, u.ProfilePicture, c.PhoneNumber, c.Address, c.PaymentDetails, c.ProfileCompleted " +
                       "FROM User u LEFT JOIN Customer c ON u.UserID = c.UserID WHERE u.UserID = ?";
        ProfileModel profile = null;

        try (Connection conn = DBConfiguration.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, userID);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                profile = new ProfileModel();
                profile.setUserID(rs.getString("UserID"));
                profile.setName(rs.getString("Name"));
                profile.setEmail(rs.getString("Email"));
                profile.setProfilePicture(rs.getString("ProfilePicture"));
                profile.setPhoneNumber(rs.getString("PhoneNumber"));
                profile.setAddress(rs.getString("Address"));
                profile.setPaymentDetails(rs.getString("PaymentDetails"));
                profile.setProfileCompleted(rs.getBoolean("ProfileCompleted"));
            }
        }

        return profile;
    }

    public boolean updateProfile(ProfileModel profile) throws SQLException {
    String query = "UPDATE Customer SET PhoneNumber = ?, Address = ?, PaymentDetails = ?, ProfileCompleted = TRUE WHERE UserID = ?";
    try (Connection conn = DBConfiguration.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        pstmt.setString(1, profile.getPhoneNumber());
        pstmt.setString(2, profile.getAddress());
        pstmt.setString(3, profile.getPaymentDetails());
        pstmt.setString(4, profile.getUserID());

        // Debug: Print SQL query and parameters
        System.out.println("Executing SQL query: " + query);
        System.out.println("Parameters: " + profile.getPhoneNumber() + ", " + profile.getAddress() + ", " + profile.getPaymentDetails() + ", " + profile.getUserID());

        int rowsUpdated = pstmt.executeUpdate();
        return rowsUpdated > 0;
    }
}
}
