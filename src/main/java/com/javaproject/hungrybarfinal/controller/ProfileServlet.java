package com.javaproject.hungrybarfinal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");

        // Fetch existing session (do not create a new one)
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userID") == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("{\"status\": \"error\", \"message\": \"Unauthorized - Please log in\"}");
            return;
        }

        String userID = (String) session.getAttribute("userID");

        // Fetch user profile details from the service layer
        CustomerService customerService = new CustomerService();

        try {
            ProfileModel profile = customerService.getUserProfile(userID);

            if (profile != null) {
                // Send profile data as JSON response
                ObjectMapper objectMapper = new ObjectMapper();
                response.getWriter().write(objectMapper.writeValueAsString(profile));
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                response.getWriter().write("{\"status\": \"error\", \"message\": \"User not found\"}");
            }

        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"status\": \"error\", \"message\": \"Error fetching profile details\"}");
        }
    }
}
