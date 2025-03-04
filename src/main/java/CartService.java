package com.javaproject.hungrybarfinal.service;

import com.javaproject.hungrybarfinal.dao.CartDAO;
import com.javaproject.hungrybarfinal.model.CartItemModel;

public class CartService {
    private CartDAO cartDAO;

    public CartService() {
        this.cartDAO = new CartDAO();
    }

    public int addCartItem(CartItemModel cartItem) {
        return cartDAO.addCartItem(cartItem);
    }
}