package com.javaproject.hungrybarfinal.controller;

import com.javaproject.hungrybarfinal.service.StaffLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@MultipartConfig
@WebServlet("/editStaff")
public class EditStaffController extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(EditStaffController.class);
    private StaffLoginService userService;

    @Override
    public void init() throws ServletException {
        try {
            this.userService = new StaffLoginService(); // Initialize LoginService
        } catch (SQLException e) {
            logger.error("Failed to initialize StaffLoginService", e);
            throw new ServletException("Failed to initialize StaffLoginService", e);
        }
    }

    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Allow requests from http://localhost:5173
    resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
    resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE");
    resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

    // Handle preflight requests (for OPTIONS method)
    if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
        resp.setStatus(HttpServletResponse.SC_OK);
        return;
    }

    // Your existing logic for handling POST requests
    String userId = req.getParameter("userId");
    String name = req.getParameter("name");
    String email = req.getParameter("email");
    String role = req.getParameter("role");
    String vehicleType = req.getParameter("vehicleType");
    String vehicleNumber = req.getParameter("vehicleNumber");

    try {
        boolean updated = userService.updateUser(userId, name, email, role, vehicleType, vehicleNumber);
        if (updated) {
            resp.getWriter().write("User updated successfully");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.getWriter().write("Failed to update user");
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        resp.getWriter().write("Database error: " + e.getMessage());
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}
}