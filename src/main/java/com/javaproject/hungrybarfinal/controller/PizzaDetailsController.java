package com.javaproject.hungrybarfinal.controller;

import com.javaproject.hungrybarfinal.service.MenuService;
import com.javaproject.hungrybarfinal.model.MenuItemModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pizza-details")
public class PizzaDetailsController extends HttpServlet {
    private MenuService menuService;
    private ObjectMapper objectMapper;

    @Override
    public void init() {
        this.menuService = new MenuService();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Enable CORS
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        
        // Set response headers
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Get the itemID from the request
        int itemID = Integer.parseInt(req.getParameter("itemID"));

        // Fetch pizza details by itemID
        MenuItemModel pizza = menuService.getPizzaById(itemID);

        // Convert the pizza object to JSON using Jackson
        String json = objectMapper.writeValueAsString(pizza);

        // Write the JSON response
        resp.getWriter().write(json);
    }
}