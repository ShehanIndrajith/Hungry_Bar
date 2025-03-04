package com.javaproject.hungrybarfinal.dao;

import com.javaproject.hungrybarfinal.model.OrderModel;
import com.javaproject.hungrybarfinal.model.OrderItemModel;
import com.javaproject.hungrybarfinal.config.DBConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public List<OrderModel> getAllOrders() throws SQLException {
        List<OrderModel> orders = new ArrayList<>();
        String query = "SELECT o.OrderID, o.CustomerID, o.RestaurantID, o.OrderDate, o.TotalPrice, o.OrderStatus, " +
                      "o.DeliveryStaffID, o.DeliveryAddress, o.EstimatedDeliveryTime, o.PaymentStatus, " +
                      "oi.ItemID, oi.Quantity, oi.SpecialInstructions " +
                      "FROM Orders o " +
                      "LEFT JOIN OrderItem oi ON o.OrderID = oi.OrderID";

        try (Connection connection = DBConfiguration.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                OrderModel order = new OrderModel();
                order.setOrderID(rs.getInt("OrderID"));
                order.setCustomerID(rs.getString("CustomerID"));
                order.setRestaurantID(rs.getInt("RestaurantID"));
                order.setOrderDate(rs.getTimestamp("OrderDate"));
                order.setTotalPrice(rs.getDouble("TotalPrice"));
                order.setOrderStatus(rs.getString("OrderStatus"));
                order.setDeliveryStaffID(rs.getString("DeliveryStaffID"));
                order.setDeliveryAddress(rs.getString("DeliveryAddress"));
                order.setEstimatedDeliveryTime(rs.getTimestamp("EstimatedDeliveryTime"));
                order.setPaymentStatus(rs.getString("PaymentStatus"));

                // Add order items
                if (rs.getInt("ItemID") > 0) {
                    OrderItemModel item = new OrderItemModel();
                    item.setItemID(rs.getInt("ItemID"));
                    item.setQuantity(rs.getInt("Quantity"));
                    item.setSpecialInstructions(rs.getString("SpecialInstructions"));
                    order.addItem(item);
                }

                orders.add(order);
            }
        }
        return orders;
    }
}