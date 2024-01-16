package com.example.springbootredis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("services")
public class MicroservicesConfig {
    private String userservice;

    public String getUserservice() {
        return userservice;
    }

    public void setUserservice(String userservice) {
        this.userservice = userservice;
    }


    private String catalogservice;

    public String getCatalogservice() {
        return catalogservice;
    }

    public void setCatalogservice(String orderservice) {
        this.catalogservice = orderservice;
    }
}
