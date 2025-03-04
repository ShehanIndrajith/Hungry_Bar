
package com.javaproject.hungrybarfinal.dao;
import com.javaproject.hungrybarfinal.config.DBConfiguration;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeliveryStaffDAO {
    public boolean updateDeliveryStaff(String userId, String vehicleType, String vehicleNumber) throws SQLException {
        String query = "UPDATE DeliveryStaff SET VehicleType = ?, VehicleNo = ? WHERE UserID = ?";
        try (Connection connection = DBConfiguration.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, vehicleType);
            stmt.setString(2, vehicleNumber);
            stmt.setString(3, userId);
            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        }
    }
}
