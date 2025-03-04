package com.javaproject.hungrybarfinal.controller;

import com.javaproject.hungrybarfinal.model.MenuItemModel;
import com.javaproject.hungrybarfinal.service.MenuService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;

@MultipartConfig
@WebServlet("/addMenuItem")
public class AddMenuItemController extends HttpServlet {
    private MenuService menuService;

    @Override
    public void init() throws ServletException {
        this.menuService = new MenuService(); // Initialize MenuService
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Allow CORS
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

        try {
            // Extract form data
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            double price = Double.parseDouble(req.getParameter("price"));
            int categoryID = Integer.parseInt(req.getParameter("categoryID"));
            String itemType = req.getParameter("itemType");
            boolean isCustomizable = Boolean.parseBoolean(req.getParameter("isCustomizable"));
            boolean available = Boolean.parseBoolean(req.getParameter("available"));
            int restaurantID = Integer.parseInt(req.getParameter("restaurantID"));

            // Handle image upload
            Part imagePart = req.getPart("image");
            String imagePath = null;
            if (imagePart != null && imagePart.getSize() > 0) {
                String fileName = System.currentTimeMillis() + "_" + imagePart.getSubmittedFileName();
                String uploadPath = "D:/Java Project/Front-End/src/Images/MenuItemImages/" + fileName; // Update this path
                imagePart.write(uploadPath);
                imagePath = "/Images/MenuItemImages/" + fileName;
            }

            // Create MenuItem object
            MenuItemModel menuItem = new MenuItemModel();
            menuItem.setName(name);
            menuItem.setDescription(description);
            menuItem.setPrice(price);
            menuItem.setCategoryID(categoryID);
            menuItem.setItemType(itemType);
            menuItem.setIsCustomizable(isCustomizable);
            menuItem.setAvailable(available);
            menuItem.setImageURL(imagePath);
            menuItem.setRestaurantID(restaurantID);

            // Add menu item to the database
            boolean added = menuService.addMenuItem(menuItem);
            if (added) {
                resp.getWriter().write("Menu item added successfully");
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.getWriter().write("Failed to add menu item");
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("Error: " + e.getMessage());
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}