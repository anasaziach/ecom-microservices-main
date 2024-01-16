package com.example.springbootredis.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootredis.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
