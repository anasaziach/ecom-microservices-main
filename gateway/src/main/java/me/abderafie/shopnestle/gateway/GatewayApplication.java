package me.abderafie.shopnestle.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@RestController
@CrossOrigin("http://localhost:4200")
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

//	@Bean
//	public CorsWebFilter corsWebFilter() {
//		CorsConfiguration corsConfig = new CorsConfiguration();
//		corsConfig.applyPermitDefaultValues();
//		corsConfig.addAllowedMethod("DELETE");
//		corsConfig.addAllowedMethod("PUT");
//		corsConfig.addAllowedMethod("GET");
//		corsConfig.addAllowedMethod("POST");
//		corsConfig.addAllowedOrigin("http://localhost:4200");
//
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", corsConfig);
//
//		return new CorsWebFilter(source);
//	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(p -> p
				.path("/products")
				.uri("http://catalog-service:8810/"))
			.route(p -> p
				.path("/products/**")
				.uri("http://catalog-service:8810/"))
			.route(p -> p
				.path("/admin/products")
				.uri("http://catalog-service:8810/"))
			.route(p -> p
				.path("/admin/products/**")
				.uri("http://catalog-service:8810/"))
			.route(p -> p
				.path("/login**")
				.uri("http://user-service:8811/"))
			.route(p -> p
				.path("/users")
				.uri("http://user-service:8811/"))
			.route(p -> p
				.path("/users/**")
				.uri("http://user-service:8811/"))
			.route(p -> p
				.path("/cart")
				.uri("http://order-service:8813/"))
			.route(p -> p
				.path("/cart/**")
				.uri("http://order-service:8813/"))
			.route(p -> p
				.path("/order/**")
				.uri("http://order-service:8813/"))
			.build();
	} 
}
