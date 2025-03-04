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
import java.util.List;

@WebServlet("/pizzas")
public class PizzaController extends HttpServlet {
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
        
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Fetch all pizzas from the service
        List<MenuItemModel> pizzas = menuService.getAllPizzas();

        // Convert the list of pizzas to JSON using Jackson
        String json = objectMapper.writeValueAsString(pizzas);

        // Write the JSON response
        resp.getWriter().write(json);
    }
}