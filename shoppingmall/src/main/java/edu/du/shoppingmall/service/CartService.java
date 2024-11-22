package edu.du.shoppingmall.service;

import edu.du.shoppingmall.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCartItems();
    void removeCartItem(Long id);
    void addOrUpdateCart(Cart cart);
}
