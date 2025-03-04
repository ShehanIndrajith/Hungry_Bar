package com.javaproject.hungrybarfinal.dao;
import com.javaproject.hungrybarfinal.config.DBConfiguration;
import com.javaproject.hungrybarfinal.model.MenuItemModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
    public boolean addMenuItem(MenuItemModel menuItem) throws SQLException {
        String query = "INSERT INTO MenuItem (Name, Description, Price, CategoryID, ItemType, IsCustomizable, Available, ImageURL, RestaurantID) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConfiguration.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, menuItem.getName());
            stmt.setString(2, menuItem.getDescription());
            stmt.setDouble(3, menuItem.getPrice());
            stmt.setInt(4, menuItem.getCategoryID());
            stmt.setString(5, menuItem.getItemType());
            stmt.setBoolean(6, menuItem.isIsCustomizable());
            stmt.setBoolean(7, menuItem.isAvailable());
            stmt.setString(8, menuItem.getImageURL());
            stmt.setInt(9, menuItem.getRestaurantID());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        }
    }
    
    public List<MenuItemModel> getAllMenuItems() throws SQLException {
        List<MenuItemModel> menuItems = new ArrayList<>();
        String query = "SELECT * FROM MenuItem";

        try (Connection connection = DBConfiguration.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MenuItemModel menuItem = new MenuItemModel();
                menuItem.setItemID(rs.getInt("ItemID"));
                menuItem.setName(rs.getString("Name"));
                menuItem.setDescription(rs.getString("Description"));
                menuItem.setPrice(rs.getDouble("Price"));
                menuItem.setCategoryID(rs.getInt("CategoryID"));
                menuItem.setItemType(rs.getString("ItemType"));
                menuItem.setIsCustomizable(rs.getBoolean("IsCustomizable"));
                menuItem.setAvailable(rs.getBoolean("Available"));
                menuItem.setImageURL(rs.getString("ImageURL"));
                menuItem.setRestaurantID(rs.getInt("RestaurantID"));
                menuItems.add(menuItem);
            }
        }
        return menuItems;
    }
    
    private static final String SEARCH_MENU_ITEMS = "SELECT * FROM MenuItem WHERE Name LIKE ?";

    public List<MenuItemModel> searchMenuItems(String query) throws SQLException {
        List<MenuItemModel> menuItems = new ArrayList<>();

        try (Connection connection = DBConfiguration.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_MENU_ITEMS)) {

            preparedStatement.setString(1, "%" + query + "%");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    MenuItemModel item = new MenuItemModel();
                    item.setItemID(resultSet.getInt("ItemID"));
                    item.setName(resultSet.getString("Name"));
                    item.setDescription(resultSet.getString("Description"));
                    item.setPrice(resultSet.getDouble("Price"));
                    item.setCategoryID(resultSet.getInt("CategoryID"));
                    item.setItemType(resultSet.getString("ItemType"));
                    item.setIsCustomizable(resultSet.getBoolean("IsCustomizable"));
                    item.setAvailable(resultSet.getBoolean("Available"));
                    item.setImageURL(resultSet.getString("ImageURL"));
                    item.setRestaurantID(resultSet.getInt("RestaurantID"));

                    menuItems.add(item);
                }
            }
        }

        return menuItems;
    }
    
    public List<MenuItemModel> getAllPizzas() {
        List<MenuItemModel> pizzas = new ArrayList<>();
        String query = "SELECT * FROM MenuItem WHERE ItemType = 'Pizza'";

        try (Connection conn = DBConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                MenuItemModel item = new MenuItemModel();
                item.setItemID(rs.getInt("ItemID"));
                item.setName(rs.getString("Name"));
                item.setDescription(rs.getString("Description"));
                item.setPrice(rs.getDouble("Price"));
                item.setCategoryID(rs.getInt("CategoryID"));
                item.setItemType(rs.getString("ItemType"));
                item.setIsCustomizable(rs.getBoolean("IsCustomizable"));
                item.setAvailable(rs.getBoolean("Available"));
                item.setImageURL(rs.getString("ImageURL"));
                item.setRestaurantID(rs.getInt("RestaurantID"));

                pizzas.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pizzas;
    }
    
    public MenuItemModel getPizzaById(int itemID) {
        MenuItemModel pizza = null;
        String query = "SELECT * FROM MenuItem WHERE ItemID = ?";

        try (Connection conn = DBConfiguration.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, itemID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pizza = new MenuItemModel();
                pizza.setItemID(rs.getInt("ItemID"));
                pizza.setName(rs.getString("Name"));
                pizza.setDescription(rs.getString("Description"));
                pizza.setPrice(rs.getDouble("Price"));
                pizza.setCategoryID(rs.getInt("CategoryID"));
                pizza.setItemType(rs.getString("ItemType"));
                pizza.setIsCustomizable(rs.getBoolean("IsCustomizable"));
                pizza.setAvailable(rs.getBoolean("Available"));
                pizza.setImageURL(rs.getString("ImageURL"));
                pizza.setRestaurantID(rs.getInt("RestaurantID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pizza;
    }
}