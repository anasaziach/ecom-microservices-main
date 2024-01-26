package com.example.springbootredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.springbootredis.config.MicroservicesConfig;

@SpringBootApplication
@EnableJpaAuditing
@EnableFeignClients
@EnableConfigurationProperties(MicroservicesConfig.class)
public class SpringBootRedisApplication {

	public static void main(String[] args) {

		


		
		SpringApplication.run(SpringBootRedisApplication.class, args);
	}

}
