package com.example.springbootredis.utilities;

import java.math.BigDecimal;

import com.example.springbootredis.entity.Product;


public class CartUtilities {

    public static BigDecimal getSubTotalForItem(Product product, int quantity){
       return (product.getPrice()).multiply(BigDecimal.valueOf(quantity));
    }
}
