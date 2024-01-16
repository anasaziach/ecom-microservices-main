package com.example.springbootredis.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springbootredis.entity.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
