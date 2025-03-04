package com.javaproject.hungrybarfinal.dao;

import  com.javaproject.hungrybarfinal.model.CartItemModel;
import  com.javaproject.hungrybarfinal.config.DBConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartDAO {

    public int addCartItem(CartItemModel cartItem) {
        String query = "INSERT INTO CartItem (CartID, ItemID, Quantity, SpecialInstructions) VALUES (?, ?, ?, ?)";
        int generatedID = -1;

        try (Connection conn = DBConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, cartItem.getCartID());
            stmt.setInt(2, cartItem.getItemID());
            stmt.setInt(3, cartItem.getQuantity());
            stmt.setString(4, cartItem.getSpecialInstructions());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    generatedID = rs.getInt(1); // Get the generated CartItemID
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return generatedID;
    }
}