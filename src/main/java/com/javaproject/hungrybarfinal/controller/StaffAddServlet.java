package com.javaproject.hungrybarfinal.controller;

import com.javaproject.hungrybarfinal.model.UserModel;
import com.javaproject.hungrybarfinal.service.StaffLoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addStaff")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
                 maxFileSize = 1024 * 1024 * 10,      // 10MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class StaffAddServlet extends HttpServlet {
    private StaffLoginService userService;

    @Override
    public void init() throws ServletException {
        try {
            this.userService = new StaffLoginService(); // Initialize LoginService
        } catch (SQLException e) {
            throw new ServletException("Failed to initialize LoginService", e);
        }
    }

    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Allow CORS
    resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
    resp.setHeader("Access-Control-Allow-Methods", "POST");
    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

    try {
        // Parse request data
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        Part profilePicturePart = req.getPart("profilePicture");
        String vehicleType = req.getParameter("vehicleType");
        String vehicleNo = req.getParameter("vehicleNumber");

        // Debug logs
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Vehicle Number: " + vehicleNo);

        // Check if role is null
        if (role == null || role.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Role is required");
            return;
        }

        // Save profile picture to server
        String profilePicturePath = null;
        if (profilePicturePart != null && profilePicturePart.getSize() > 0) {
            String fileName = System.currentTimeMillis() + "_" + profilePicturePart.getSubmittedFileName();
            String uploadPath = "D:/Java Project/Front-End/src/Images/StaffProfileImages/" + fileName; // Update this path
            profilePicturePart.write(uploadPath);
            profilePicturePath = "/Images/StaffProfileImages/" + fileName;
        }

        // Create a UserModel object
        UserModel user = new UserModel();
        user.setUserID(generateUserID(role)); // Replace with your logic to generate UserID
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setProfilePicture(profilePicturePath);

        // Add the user to the database
        boolean success = userService.addUser(user, vehicleType, vehicleNo);

        if (success) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("User added successfully");
        } else {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("Failed to add user");
        }
    } catch (Exception e) {
        // Log the exception
        e.printStackTrace();
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        resp.getWriter().write("Internal Server Error: " + e.getMessage());
    }
}

    private String generateUserID(String role) {
        if (role == null || role.isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty");
        }
        return role.substring(0, Math.min(3, role.length())).toUpperCase() + System.currentTimeMillis();
    }
}