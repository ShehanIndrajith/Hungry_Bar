package com.javaproject.hungrybarfinal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaproject.hungrybarfinal.model.UserModel;
import com.javaproject.hungrybarfinal.service.CustomerService;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set CORS headers to allow requests from your React frontend
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");  // Allow React front-end
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // Parse JSON request body into UserModel object
        UserModel loginRequest = objectMapper.readValue(request.getInputStream(), UserModel.class);

        // Authenticate user (replace with your actual service logic)
        CustomerService userService = new CustomerService();
        try {
            UserModel user = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

            if (user != null) {
                // Start session and store userID in session
                HttpSession session = request.getSession();
                session.setAttribute("userID", user.getUserID());

                // Set JSESSIONID cookie to allow React to maintain session
                Cookie sessionCookie = new Cookie("JSESSIONID", session.getId());
                sessionCookie.setPath("/");
                sessionCookie.setDomain("localhost");
                sessionCookie.setHttpOnly(true);
                sessionCookie.setSecure(false);  // For local development (http only), set to true in production with HTTPS
                response.addCookie(sessionCookie);

                // Set SameSite=None manually (Tomcat 9 doesn't handle this well in Cookie API)
                response.addHeader("Set-Cookie", "JSESSIONID=" + session.getId() + "; Path=/; HttpOnly; SameSite=None");

                // Send success response with userID (optional)
                response.setStatus(HttpServletResponse.SC_OK);
                objectMapper.writeValue(response.getWriter(), new LoginResponse(true, "Login successful", user.getUserID()));
            } else {
                // Invalid credentials response
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                objectMapper.writeValue(response.getWriter(), new LoginResponse(false, "Invalid email or password", null));
            }
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            objectMapper.writeValue(response.getWriter(), new LoginResponse(false, "Login failed. Please try again.", null));
        }
    }

    // Handle preflight (CORS) requests from React
    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    // Helper class for login response JSON
    private static class LoginResponse {
        private final boolean success;
        private final String message;
        private final String userID;

        public LoginResponse(boolean success, String message, String userID) {
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
