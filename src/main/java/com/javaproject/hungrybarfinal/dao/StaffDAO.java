package com.javaproject.hungrybarfinal.dao;
import com.javaproject.hungrybarfinal.model.UserModel;
import com.javaproject.hungrybarfinal.config.DBConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {
    private Connection connection;

    public StaffDAO() throws SQLException {
        this.connection = DBConfiguration.getConnection();
    }

    public UserModel getUserByEmailAndRole(String email, String role) throws SQLException {
        String query = "SELECT * FROM User WHERE Email = ? AND Role = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, role);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                UserModel user = new UserModel();
                user.setUserID(rs.getString("UserID"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setRole(rs.getString("Role"));
                user.setAuthProvider(rs.getString("AuthProvider"));
                user.setProfilePicture(rs.getString("ProfilePicture"));
                user.setCreatedAt(rs.getTimestamp("CreatedAt").toLocalDateTime());
                return user;
            }
        }
        return null;
    }
    
    // Add a new user to the database
    public boolean addUser(UserModel user) throws SQLException {
        String query = "INSERT INTO User (UserID, Name, Email, Password, Role, AuthProvider, ProfilePicture, CreatedAt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getUserID());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getRole());
            stmt.setString(6, user.getAuthProvider());
            stmt.setString(7, user.getProfilePicture());
            stmt.setObject(8, user.getCreatedAt());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }

    // Add a delivery staff member to the DeliveryStaff table
    public boolean addDeliveryStaff(String userID, String vehicleDetails) throws SQLException {
        String query = "INSERT INTO DeliveryStaff (UserID, AssignedRestaurantID, VehicleDetails) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userID);
            stmt.setInt(2, 1); // Replace with actual restaurant ID
            stmt.setString(3, vehicleDetails);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        }
    }
    
    public List<UserModel> getAllStaff() throws SQLException {
    List<UserModel> staffList = new ArrayList<>();
    String query = "SELECT u.UserID, u.Name, u.Email, u.Role, u.ProfilePicture, u.Status, d.VehicleType, d.VehicleNo "
                 + "FROM User u "
                 + "LEFT JOIN DeliveryStaff d ON u.UserID = d.UserID "
                 + "WHERE u.Role IN ('manager', 'KitchenStaff', 'DeliveryStaff')";

    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            UserModel user = new UserModel();
            user.setUserID(rs.getString("UserID"));
            user.setName(rs.getString("Name"));
            user.setEmail(rs.getString("Email"));
            user.setRole(rs.getString("Role"));

            // Construct the image URL
            String profilePicturePath = rs.getString("ProfilePicture");
            String profilePictureFilename = profilePicturePath != null
                ? profilePicturePath.substring(profilePicturePath.lastIndexOf('/') + 1)
                : null;
            user.setProfilePicture(profilePictureFilename != null
                ? "http://localhost:8080/HungryBarFinal/images/" + profilePictureFilename
                : null);

            user.setStatus(rs.getString("Status")); // Set the status
            // Set VehicleType and VehicleNo for DeliveryStaff
            if ("DeliveryStaff".equals(user.getRole())) {
                user.setVehicleType(rs.getString("VehicleType"));
                user.setVehicleNo(rs.getString("VehicleNo"));
            }
            staffList.add(user); // Add the user to the list only once
        }
    }
    return staffList;
}
    
    public boolean addDeliveryStaff(String userID, String vehicleType, String vehicleNo) throws SQLException {
    String query = "INSERT INTO DeliveryStaff (UserID, AssignedRestaurantID, VehicleType, VehicleNo) VALUES (?, ?, ?, ?)";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        stmt.setString(1, userID);
        stmt.setInt(2, 1); // Replace with actual restaurant ID
        stmt.setString(3, vehicleType);
        stmt.setString(4, vehicleNo);

        int rowsAffected = stmt.executeUpdate();
        return rowsAffected > 0;
    }
    
    
}
    public boolean updateUser(String userId, String name, String email, String role) throws SQLException {
        String query = "UPDATE User SET Name = ?, Email = ?, Role = ? WHERE UserID = ?";
        try (
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, role);
            stmt.setString(4, userId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
    
    public boolean deleteUser(String userId) throws SQLException {
        String query = "DELETE FROM User WHERE UserID = ?";
        try (
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, userId);
            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}

