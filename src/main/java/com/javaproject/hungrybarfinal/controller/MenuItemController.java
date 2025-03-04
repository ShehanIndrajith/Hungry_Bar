package com.javaproject.hungrybarfinal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaproject.hungrybarfinal.model.MenuItemModel;
import com.javaproject.hungrybarfinal.service.MenuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/search")
public class MenuItemController extends HttpServlet {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final MenuService menuItemService = new MenuService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Enable CORS
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        // Get the search query from the request
        String query = request.getParameter("query");

        try {
            // Fetch menu items matching the search query
            List<MenuItemModel> menuItems = menuItemService.searchMenuItems(query);

            if (menuItems.isEmpty()) {
                // No items found
                response.setStatus(HttpServletResponse.SC_OK); // 200 OK
                response.getWriter().write("{\"message\": \"No items found for your search.\"}");
            } else {
                // Return the menu items as JSON
                response.setContentType("application/json");
                objectMapper.writeValue(response.getWriter(), menuItems);
            }
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"An error occurred while searching for menu items.\"}");
        }
    }
}