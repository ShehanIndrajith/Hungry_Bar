package com.javaproject.hungrybarfinal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getUserID")
public class GetUserIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set CORS headers
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // Get the session (do not create a new one if it doesn't exist)
        HttpSession session = request.getSession(false);
        if (session == null) {
    System.out.println("No session found");
} else {
    System.out.println("Session ID: " + session.getId());
    System.out.println("userID: " + session.getAttribute("userID"));
}

        if (session != null && session.getAttribute("userID") != null) {
            String userID = (String) session.getAttribute("userID");
            response.setContentType("application/json");
            response.getWriter().write("{\"userID\": \"" + userID + "\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}