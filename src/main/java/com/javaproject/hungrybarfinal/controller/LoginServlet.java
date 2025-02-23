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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to the login page (loginpage.jsp)
        request.getRequestDispatcher("/WEB-INF/View/loginpage.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Debug: Print form data
        System.out.println("Login attempt: Email=" + email + ", Password=" + password);

        // Authenticate the user
        CustomerService userService = new CustomerService();
        try {
            UserModel user = userService.authenticateUser(email, password);

            if (user != null) {
                // Store user details in the session
                HttpSession session = request.getSession();
                session.setAttribute("user", user); // Store the entire user object
                session.setAttribute("userID", user.getUserID()); // Store UserID separately

                // Debug: Print session details
                System.out.println("Login successful: UserID=" + user.getUserID() + ", Email=" + user.getEmail());

                // Redirect to home page
                request.getRequestDispatcher("/WEB-INF/View/home.jsp").forward(request, response);
            } else {
                // Invalid credentials
                System.out.println("Login failed: Invalid credentials");
                request.setAttribute("errorMessage", "Invalid email or password.");
                request.getRequestDispatcher("/WEB-INF/View/loginpage.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            System.out.println("SQLException occurred: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("errorMessage", "Login failed. Please try again.");
            request.getRequestDispatcher("/WEB-INF/View/loginpage.jsp").forward(request, response);
        }
    }
}