package com.example.springbootredis.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.springbootredis.entity.User;
// ${services.userservice}
@FeignClient(name = "User", url = "http://user-service:8811/")
//@FeignClient(name = "User", url = "http://localhost:8811/")
public interface UserClient {

    @GetMapping(value = "/users/{id}")
    public User getUserById(@PathVariable("id") Long id);
}
