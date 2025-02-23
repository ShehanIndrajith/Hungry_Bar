package com.javaproject.hungrybarfinal.controller;
import com.javaproject.hungrybarfinal.model.ProfileModel;
import com.javaproject.hungrybarfinal.service.CustomerService;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit-profile")
public class EditProfileServlet extends HttpServlet {
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Forward to the edit profile form (edit-profile.jsp)
    request.getRequestDispatcher("/WEB-INF/View/edit-profile.jsp").forward(request, response);
}

    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Get UserID from the session
    HttpSession session = request.getSession();
    String userID = (String) session.getAttribute("userID");

    if (userID == null) {
        // Redirect to login if UserID is not in session
        response.sendRedirect("login");
        return;
    }

    // Get form data
    String phoneNumber = request.getParameter("phoneNumber");
    String address = request.getParameter("address");
    String paymentDetails = request.getParameter("paymentDetails");
    String profilePicture = request.getParameter("profilePicture");

    // Debug: Print form data
    System.out.println("Form data received:");
    System.out.println("Phone Number: " + phoneNumber);
    System.out.println("Address: " + address);
    System.out.println("Payment Details: " + paymentDetails);
    System.out.println("Profile Picture: " + profilePicture);

    // Validate phone number (Sri Lanka format: +94XXXXXXXXX)
    if (!phoneNumber.matches("\\+94\\d{9}")) {
        System.out.println("Invalid phone number: " + phoneNumber);
        request.setAttribute("errorMessage", "Invalid phone number. Please use the format +94XXXXXXXXX.");
        request.getRequestDispatcher("/WEB-INF/View/edit-profile.jsp").forward(request, response);
        return;
    }

    // Create a ProfileModel object
    ProfileModel profile = new ProfileModel();
    profile.setUserID(userID);
    profile.setPhoneNumber(phoneNumber);
    profile.setAddress(address);
    profile.setPaymentDetails(paymentDetails);
    profile.setProfilePicture(profilePicture);

    // Update profile details
    CustomerService customerService = new CustomerService();
    try {
        boolean isUpdated = customerService.updateProfile(profile);

        if (isUpdated) {
            // Redirect to profile page
            response.sendRedirect("profile");
        } else {
            // Handle error (e.g., update failed)
            System.out.println("Failed to update profile.");
            request.setAttribute("errorMessage", "Failed to update profile.");
            request.getRequestDispatcher("/WEB-INF/View/edit-profile.jsp").forward(request, response);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("SQLException: " + e.getMessage());
        request.setAttribute("errorMessage", "Error updating profile details.");
        request.getRequestDispatcher("/WEB-INF/View/edit-profile.jsp").forward(request, response);
    }
}
}