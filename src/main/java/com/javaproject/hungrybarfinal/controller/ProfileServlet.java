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

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get UserID from the session
        HttpSession session = request.getSession();
        String userID = (String) session.getAttribute("userID");

        if (userID == null) {
            // Redirect to login if UserID is not in session
            response.sendRedirect("login");
            return;
        }

        // Fetch user profile details
        CustomerService customerService = new CustomerService();
        try {
            ProfileModel profile = customerService.getUserProfile(userID);

            if (profile != null) {
                // Set profile details in the request
                request.setAttribute("profile", profile);

                // Forward to profile page
                request.getRequestDispatcher("/WEB-INF/View/profile.jsp").forward(request, response);
            } else {
                // Handle error (e.g., user not found)
                request.setAttribute("errorMessage", "User not found.");
                request.getRequestDispatcher("/WEB-INF/View/profile.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error fetching profile details.");
            request.getRequestDispatcher("/WEB-INF/View/profile.jsp").forward(request, response);
        }
    }
}

