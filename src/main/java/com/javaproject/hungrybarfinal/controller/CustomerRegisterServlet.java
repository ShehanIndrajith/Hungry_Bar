package com.javaproject.hungrybarfinal.controller;
import com.javaproject.hungrybarfinal.model.UserModel;
import com.javaproject.hungrybarfinal.service.CustomerService;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class CustomerRegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the registration form (register.jsp)
        request.getRequestDispatcher("/WEB-INF/View/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Debug: Print form data
        System.out.println("Form data received: Name=" + name + ", Email=" + email + ", Password=" + password);

        // Create a User object
        UserModel user = new UserModel();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        // Debug: Print user object
        System.out.println("User object created: " + user);

        // Register the user
        CustomerService userService = new CustomerService();
        try {
            System.out.println("Calling CustomerService.registerCustomer");
            String userID = userService.registerCustomer(user);

            System.out.println("User registered successfully with ID: " + userID);

            // Store UserID in the session
            HttpSession session = request.getSession();
            session.setAttribute("userID", userID);

            // Redirect to success page
            System.out.println("Forwarding to register-success.jsp");
            request.getRequestDispatcher("/WEB-INF/View/register-success.jsp").forward(request, response);
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            System.out.println("Forwarding to register.jsp with error message");
            request.getRequestDispatcher("/WEB-INF/View/register.jsp").forward(request, response);
        }
    }
}

