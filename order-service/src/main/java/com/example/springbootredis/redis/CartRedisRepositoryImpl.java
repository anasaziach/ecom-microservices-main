package com.example.springbootredis.redis;


import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import java.util.ArrayList;
import java.util.Collection;

import com.example.springbootredis.entity.Item;

@Repository
public class CartRedisRepositoryImpl implements CartRedisRepository{
//public class CartRedisRepositoryImpl{

	private static final String ITEM = "ITEM";
	private RedisTemplate<String, Object> redisTemplate;

	private HashOperations<String,String, Collection<Item>> hashOperations;

	@Autowired
	public CartRedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate) {
		this.redisTemplate = redisTemplate;
		init();
	}

	public void init() {
		this.hashOperations = redisTemplate.opsForHash();
	}


    @Override
    public void addItemToCart(String key, Item item) {
            Collection<Item> cart = getCart(key);
            cart.add(item);
            hashOperations.put(ITEM,key,cart);
        System.out.println(item);
    }

    @Override
    public Collection<Item> getCart(String key) {
        Collection<Item> cart = new ArrayList<>();
        System.out.println(cart);
        try {
            if ((Collection<Item>) hashOperations.get(ITEM,key) !=null)
            cart = (Collection<Item>) hashOperations.get(ITEM,key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(cart);
        return cart;
    }

    @Override
    public void deleteItemFromCart(String key, Object item) {
    }

    @Override
    public void deleteCart(String key) {
    }

    @Override
    public String initCart() {
        throw new UnsupportedOperationException("Unimplemented method 'initCart'");
    }
}
