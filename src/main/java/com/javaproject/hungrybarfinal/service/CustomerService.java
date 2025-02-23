package com.javaproject.hungrybarfinal.service;
import com.javaproject.hungrybarfinal.model.UserModel;
import com.javaproject.hungrybarfinal.model.ProfileModel;
import com.javaproject.hungrybarfinal.model.CustomerModel;
import com.javaproject.hungrybarfinal.dao.CustomerDAO;
import java.sql.SQLException;

public class CustomerService {
    private CustomerDAO customerDAO = new CustomerDAO();

    // Register a new customer
    public String registerCustomer(UserModel user) throws SQLException {
        // Set the role to "Customer"
        user.setRole("Customer");

        // Call DAO to register the user
        return customerDAO.registerUser(user);
    }
    
    // Authenticate user
    public UserModel authenticateUser(String email, String password) throws SQLException {
        return customerDAO.authenticateUser(email, password);
    }
    
    // Fetch combined user and customer details
    public ProfileModel getUserProfile(String userID) throws SQLException {
        UserModel user = customerDAO.getUserDetails(userID);
        CustomerModel customer = customerDAO.getCustomerDetails(userID);

        ProfileModel profile = new ProfileModel();
        if (user != null) {
            profile.setUserID(user.getUserID());
            profile.setName(user.getName());
            profile.setEmail(user.getEmail());
            profile.setProfilePicture(user.getProfilePicture());
        }
        if (customer != null) {
            profile.setPhoneNumber(customer.getPhoneNumber());
            profile.setAddress(customer.getAddress());
            profile.setPaymentDetails(customer.getPaymentDetails());
            profile.setProfileCompleted(customer.isProfileCompleted());
        }

        return profile;
    }
    // Fetch profile details
    public ProfileModel getProfileDetails(String userID) throws SQLException {
        return customerDAO.getProfileDetails(userID);
    }

    // Update profile details
    public boolean updateProfile(ProfileModel profile) throws SQLException {
        return customerDAO.updateProfile(profile);
    }
}
