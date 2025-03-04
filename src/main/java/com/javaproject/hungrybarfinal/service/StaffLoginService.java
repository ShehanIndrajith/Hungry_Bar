package com.javaproject.hungrybarfinal.service;
import com.javaproject.hungrybarfinal.model.UserModel;
import com.javaproject.hungrybarfinal.dao.DeliveryStaffDAO;
import com.javaproject.hungrybarfinal.dao.StaffDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class StaffLoginService {
    private StaffDAO userDAO;
    private DeliveryStaffDAO deliveryStaffDAO = new DeliveryStaffDAO();

    public StaffLoginService() throws SQLException {
        // Initialize UserDAO
        this.userDAO = new StaffDAO();
    }

    public UserModel authenticateUser(String email, String password, String role) throws SQLException {
        UserModel user = userDAO.getUserByEmailAndRole(email, role);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    
    // Add a new user
    public boolean addUser(UserModel user, String vehicleType, String vehicleNo) throws SQLException {
        // Set default values
        user.setAuthProvider("Email");
        user.setCreatedAt(LocalDateTime.now());

        // Add user to the User table
        boolean userAdded = userDAO.addUser(user);

        // If the user is a delivery staff, add to the DeliveryStaff table
    if (userAdded && "DeliveryStaff".equals(user.getRole())) {
        return userDAO.addDeliveryStaff(user.getUserID(), vehicleType, vehicleNo);
    }

        return userAdded;
    }
    // Fetch all staff members
    public List<UserModel> getAllStaff() throws SQLException {
        return userDAO.getAllStaff();
    }
    
    public boolean updateUser(String userId, String name, String email, String role, String vehicleType, String vehicleNumber) throws SQLException {
        // Update User table
        boolean userUpdated = userDAO.updateUser(userId, name, email, role);

        // Update DeliveryStaff table if the role is DeliveryStaff
        if (role.equals("DeliveryStaff")) {
            boolean deliveryStaffUpdated = deliveryStaffDAO.updateDeliveryStaff(userId, vehicleType, vehicleNumber);
            return userUpdated && deliveryStaffUpdated;
        }

        return userUpdated;
    }
    
    public boolean deleteUser(String userId) throws SQLException {
        return userDAO.deleteUser(userId);
    }
}
