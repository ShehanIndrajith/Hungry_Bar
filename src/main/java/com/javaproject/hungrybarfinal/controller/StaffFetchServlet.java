package com.javaproject.hungrybarfinal.controller;
import com.javaproject.hungrybarfinal.model.UserModel;
import com.javaproject.hungrybarfinal.service.StaffLoginService;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/fetchStaff")
public class StaffFetchServlet extends HttpServlet {
    private StaffLoginService staffService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        try {
            this.staffService = new StaffLoginService(); // Initialize StaffLoginService
            this.objectMapper = new ObjectMapper(); // Initialize Jackson ObjectMapper
        } catch (SQLException e) {
            throw new ServletException("Failed to initialize StaffLoginService", e);
        }
    }

    @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Allow CORS
    resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
    resp.setHeader("Access-Control-Allow-Methods", "GET");
    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

    try {
        // Fetch all staff members from the database
        List<UserModel> staffList = staffService.getAllStaff();

        // Convert the list to JSON
        String jsonResponse = objectMapper.writeValueAsString(staffList);

        // Send the JSON response
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);
    } catch (Exception e) {
        // Log the exception
        e.printStackTrace();
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        resp.getWriter().write("Internal Server Error: " + e.getMessage());
    }
}
}