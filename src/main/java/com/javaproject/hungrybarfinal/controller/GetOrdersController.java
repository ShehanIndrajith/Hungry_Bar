package com.javaproject.hungrybarfinal.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaproject.hungrybarfinal.model.OrderModel;
import com.javaproject.hungrybarfinal.service.OrderService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/getOrders")
public class GetOrdersController extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        this.orderService = new OrderService(); // Initialize OrderService
    }

    @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Allow CORS
    resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
    resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
    resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");

    try {
        List<OrderModel> orders = orderService.getAllOrders();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        // Convert orders to JSON using Jackson
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(orders);
        resp.getWriter().write(jsonResponse);
    } catch (SQLException e) {
        e.printStackTrace();
        resp.getWriter().write("Database error: " + e.getMessage());
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}
}