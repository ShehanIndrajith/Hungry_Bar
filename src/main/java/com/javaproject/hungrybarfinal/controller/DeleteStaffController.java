package com.javaproject.hungrybarfinal.controller;

import com.javaproject.hungrybarfinal.service.StaffLoginService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteStaff")
public class DeleteStaffController extends HttpServlet {
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
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        // Handle preflight requests
        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // Extract user ID from request
        String userId = req.getParameter("userId");

        if (userId == null || userId.isEmpty()) {
            resp.getWriter().write("User ID is required");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            boolean deleted = userService.deleteUser(userId);
            if (deleted) {
                resp.getWriter().write("User deleted successfully");
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.getWriter().write("Failed to delete user");
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("Database error: " + e.getMessage());
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}