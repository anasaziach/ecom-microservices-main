package com.example.springbootredis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springbootredis.Services.CartService;
import com.example.springbootredis.entity.Item;
import com.example.springbootredis.http.header.HeaderGenerator;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CartController {

    @Autowired
    CartService cartService;
    
    @Autowired
    private HeaderGenerator headerGenerator;
    // @GetMapping (value = "/cart/init")
    // public ResponseEntity<Object> initCart(){
    //     String cartId = cartService.initCart();
	// 	Map<String, String> data = new HashMap<>();
    //     data.put("cartID", cartId);
	// 	return new ResponseEntity<>(
	// 			data,
	// 			headerGenerator.getHeadersForSuccessGetMethod(),
	// 			HttpStatus.OK);
    // }

    @GetMapping (value = "/cart/getCart/{CartId}")
    public ResponseEntity<List<Item>> getCart(@PathVariable("CartId") String cartId){
        List<Item> cart = cartService.getCart(cartId);
        if(!cart.isEmpty()) {
        	return new ResponseEntity<List<Item>>(
        			cart,
        			headerGenerator.getHeadersForSuccessGetMethod(),
        			HttpStatus.OK);
        }
    	return new ResponseEntity<List<Item>>(
    			headerGenerator.getHeadersForError(),
    			HttpStatus.NOT_FOUND);  
    }

    @GetMapping(value = "/cart/addProductToCart/{CartId}/{productId}/{quantity}")
    public ResponseEntity<List<Item>> addItemToCart(
            @PathVariable("productId") Long productId,
            @PathVariable("quantity") Integer quantity,
            @PathVariable("CartId") String cartId,
            HttpServletRequest request) {
        List<Item> cart = cartService.getCart(cartId);
		System.out.println("cartId: " + cart);
        if(cart != null) {
        	if(cart.isEmpty()){
        		cartService.addItemToCart(cartId, productId, quantity);
        	}else{
        		if(cartService.checkIfItemIsExist(cartId, productId)){
        			cartService.changeItemQuantity(cartId, productId, quantity);
        		}else {
        			cartService.addItemToCart(cartId, productId, quantity);
        		}
        	}
        	return new ResponseEntity<List<Item>>(
        			cart,
        			headerGenerator.getHeadersForSuccessPostMethod(request, Long.parseLong(cartId)),
        			HttpStatus.CREATED);
        }
        return new ResponseEntity<List<Item>>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/cart", params = "productId")
    public ResponseEntity<Void> removeItemFromCart(
            @RequestParam("productId") Long productId,
            @RequestHeader(value = "Cookie") String cartId){
    	List<Item> cart = cartService.getCart(cartId);
    	if(cart != null) {
    		cartService.deleteItemFromCart(cartId, productId);
            return new ResponseEntity<Void>(
            		headerGenerator.getHeadersForSuccessGetMethod(),
            		HttpStatus.OK);
    	}
        return new ResponseEntity<Void>(
        		headerGenerator.getHeadersForError(),
        		HttpStatus.NOT_FOUND);
    }
}
