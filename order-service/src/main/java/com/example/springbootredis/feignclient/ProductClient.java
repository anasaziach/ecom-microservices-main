package com.example.springbootredis.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.springbootredis.entity.Product;
// services.catalogservice
@FeignClient(name = "product", url = "http://catalog-service:8810/")
//@FeignClient(name = "product", url = "http://localhost:8810/")
public interface ProductClient {

    @GetMapping(value = "/products/id/{id}")
    public Product getProductById(@PathVariable(value = "id") Long productId);

}
