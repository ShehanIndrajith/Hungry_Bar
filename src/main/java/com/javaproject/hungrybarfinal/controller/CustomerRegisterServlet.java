package com.javaproject.hungrybarfinal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaproject.hungrybarfinal.model.UserModel;
import com.javaproject.hungrybarfinal.service.CustomerService;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class CustomerRegisterServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173"); // Allow requests from your React app
response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
response.setHeader("Access-Control-Allow-Credentials", "true");
        // Set response content type to JSON
        response.setContentType("application/json");

        // Parse JSON request body to UserModel
        UserModel user = objectMapper.readValue(request.getInputStream(), UserModel.class);

        // Register the user
        CustomerService userService = new CustomerService();
        try {
            String userID = userService.registerCustomer(user);

            // Return success response
            response.setStatus(HttpServletResponse.SC_OK);
            objectMapper.writeValue(response.getWriter(), new RegistrationResponse(true, "Registration successful", userID));
        } catch (SQLException e) {
            // Return error response
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            objectMapper.writeValue(response.getWriter(), new RegistrationResponse(false, "Registration failed: " + e.getMessage(), null));
        }
    }

    @Override
protected void doOptions(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // Enable CORS
    response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    response.setHeader("Access-Control-Allow-Credentials", "true");

    response.setStatus(HttpServletResponse.SC_OK);
}
    private static class RegistrationResponse {
        private final boolean success;
        private final String message;
        private final String userID;

        public RegistrationResponse(boolean success, String message, String userID) {
            this.success = success;
            this.message = message;
            this.userID = userID;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }

        public String getUserID() {
            return userID;
        }
    }
}