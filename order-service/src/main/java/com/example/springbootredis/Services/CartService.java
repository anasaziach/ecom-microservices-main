package com.example.springbootredis.Services;
import java.util.List;

import com.example.springbootredis.entity.Item;

public interface CartService {

    public void addItemToCart(String cartId, Long productId, Integer quantity);
    public String initCart();
    public List<Item> getCart(String cartId);
    public void changeItemQuantity(String cartId, Long productId, Integer quantity);
    public void deleteItemFromCart(String cartId, Long productId);
    public boolean checkIfItemIsExist(String cartId, Long productId);
    public List<Item> getAllItemsFromCart(String cartId);
    public void deleteCart(String cartId);
}
