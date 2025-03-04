package com.javaproject.hungrybarfinal.service;

import com.javaproject.hungrybarfinal.dao.MenuDAO;
import com.javaproject.hungrybarfinal.model.MenuItemModel;
import com.javaproject.hungrybarfinal.dao.RestaurantDAO;
import java.sql.SQLException;
import java.util.List;

public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();
    private RestaurantDAO restaurantDAO = new RestaurantDAO();

    public boolean isRestaurantValid(int restaurantID) throws SQLException {
        return restaurantDAO.getRestaurantById(restaurantID) != null;
    }
    
    public boolean addMenuItem(MenuItemModel menuItem) throws SQLException {
        return menuDAO.addMenuItem(menuItem);
    }
    
    public List<MenuItemModel> getAllMenuItems() throws SQLException {
        return menuDAO.getAllMenuItems();
    }
    
     public List<MenuItemModel> searchMenuItems(String query) throws SQLException {
        return menuDAO.searchMenuItems(query);
    }
     
     public List<MenuItemModel> getAllPizzas() {
        return menuDAO.getAllPizzas();
    }
     
     public MenuItemModel getPizzaById(int itemID) {
        return menuDAO.getPizzaById(itemID);
    }
}