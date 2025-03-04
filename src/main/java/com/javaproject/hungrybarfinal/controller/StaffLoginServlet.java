package com.javaproject.hungrybarfinal.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaproject.hungrybarfinal.service.StaffLoginService;
import com.javaproject.hungrybarfinal.config.DBConfiguration;
import com.javaproject.hungrybarfinal.model.UserModel;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/stafflogin")
public class StaffLoginServlet extends HttpServlet {

    private StaffLoginService loginService;
    private ObjectMapper objectMapper; // Jackson ObjectMapper

    @Override
    public void init() throws ServletException {
        try {
            this.loginService = new StaffLoginService(); // Initialize LoginService
            this.objectMapper = new ObjectMapper(); // Initialize Jackson ObjectMapper
        } catch (SQLException e) {
            throw new ServletException("Failed to initialize LoginService", e);
        }
    }

    @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Allow requests from http://localhost:5173
    resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
    resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

    // Get request parameters
    String email = req.getParameter("email");
    String password = req.getParameter("password");
    String role = req.getParameter("role");

    // Validate credentials against the database
    try {
        // Get a database connection
        Connection connection = DBConfiguration.getConnection();

        // Query the database to check if the user exists
        String query = "SELECT * FROM User WHERE Email = ? AND Password = ? AND Role = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, email);
        stmt.setString(2, password); // In a real application, use hashed passwords
        stmt.setString(3, role);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // User exists, create a UserModel object
            UserModel user = new UserModel();
            user.setUserID(rs.getString("UserID"));
            user.setName(rs.getString("Name"));
            user.setEmail(rs.getString("Email"));
            user.setRole(rs.getString("Role"));

            // Send JSON response
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            new ObjectMapper().writeValue(resp.getWriter(), user);
        } else {
            // Invalid credentials
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().write("Invalid credentials");
        }
    } catch (SQLException e) {
        // Handle database errors
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        resp.getWriter().write("Database error: " + e.getMessage());
    }
}
@Override
protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Allow preflight requests
    resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
    resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
    resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    resp.setStatus(HttpServletResponse.SC_OK);
}
}


