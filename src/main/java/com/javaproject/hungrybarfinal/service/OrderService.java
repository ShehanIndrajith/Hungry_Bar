package com.javaproject.hungrybarfinal.service;

import com.javaproject.hungrybarfinal.dao.OrderDAO;
import com.javaproject.hungrybarfinal.model.OrderModel;
import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAO();

    public List<OrderModel> getAllOrders() throws SQLException {
        return orderDAO.getAllOrders();
    }
}