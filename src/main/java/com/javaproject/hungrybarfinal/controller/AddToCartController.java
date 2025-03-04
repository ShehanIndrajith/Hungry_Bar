package com.javaproject.hungrybarfinal.controller;

import com.javaproject.hungrybarfinal.service.CartService;
import com.javaproject.hungrybarfinal.model.CartItemModel;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addToCart")
public class AddToCartController extends HttpServlet {
    private CartService cartService;
    private ObjectMapper objectMapper;

    @Override
    public void init() {
        this.cartService = new CartService();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set CORS headers
        setCorsHeaders(resp);

        // Handle preflight OPTIONS request
        if ("OPTIONS".equalsIgnoreCase(req.getMethod())) {
            resp.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // Parse the request body
        CartItemModel cartItem = objectMapper.readValue(req.getInputStream(), CartItemModel.class);

        // Add the item to the cart
        int cartItemID = cartService.addCartItem(cartItem);

        // Send the response
        if (cartItemID != -1) {
            resp.getWriter().write("{\"status\": \"success\", \"cartItemID\": " + cartItemID + "}");
        } else {
            resp.getWriter().write("{\"status\": \"error\", \"message\": \"Failed to add item to cart\"}");
        }
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setCorsHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void setCorsHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:5173"); // Allow requests from frontend
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
    }
}