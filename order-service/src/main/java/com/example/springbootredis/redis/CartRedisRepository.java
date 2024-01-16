package com.example.springbootredis.redis;


import java.util.Collection;

import com.example.springbootredis.entity.Item;

public interface CartRedisRepository {
    public String initCart();
    public void addItemToCart(String key, Item item);
    public Collection<Item> getCart(String key);
    public void deleteItemFromCart(String key, Object item);
    public void deleteCart(String key);
}
