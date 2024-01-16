package com.example.springbootredis.Services;

import com.example.springbootredis.entity.Order;

public interface OrderService {
    public Order saveOrder(Order order);
}
