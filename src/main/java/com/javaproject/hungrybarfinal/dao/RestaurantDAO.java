package com.javaproject.hungrybarfinal.dao;
import com.javaproject.hungrybarfinal.model.RestaurantModel;
import com.javaproject.hungrybarfinal.config.DBConfiguration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RestaurantDAO {
    public RestaurantModel getRestaurantById(int restaurantID) throws SQLException {
        String query = "SELECT * FROM Restaurant WHERE RestaurantID = ?";
        try (Connection connection = DBConfiguration.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, restaurantID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    RestaurantModel restaurant = new RestaurantModel();
                    restaurant.setRestaurantID(rs.getInt("RestaurantID"));
                    restaurant.setName(rs.getString("Name"));
                    // Set other fields as needed
                    return restaurant;
                }
            }
        }
        return null;
    }
}
