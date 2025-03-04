package com.javaproject.hungrybarfinal.controller;
import com.javaproject.hungrybarfinal.model.MenuItemModel;
import com.javaproject.hungrybarfinal.service.MenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getMenuItems")
public class GetMenuItemsController extends HttpServlet {
    private MenuService menuService = new MenuService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Allow CORS
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        try {
            List<MenuItemModel> menuItems = menuService.getAllMenuItems();
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            // Convert menuItems to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonResponse = objectMapper.writeValueAsString(menuItems);
            resp.getWriter().write(jsonResponse);
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("Database error: " + e.getMessage());
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}