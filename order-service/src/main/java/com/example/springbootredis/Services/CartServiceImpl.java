package com.example.springbootredis.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootredis.entity.Item;
import com.example.springbootredis.entity.Product;
import com.example.springbootredis.feignclient.ProductClient;
import com.example.springbootredis.redis.CartRedisRepository;
import com.example.springbootredis.utilities.CartUtilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductClient productClient;
 
    @Autowired
    private CartRedisRepository cartRedisRepository;
    public String initCart(){
        return cartRedisRepository.initCart();
    }
    @Override
    public void addItemToCart(String cartId, Long productId, Integer quantity) {
        Product product = productClient.getProductById(productId);
        Item item = new Item(quantity,product, CartUtilities.getSubTotalForItem(product,quantity));
        cartRedisRepository.addItemToCart(cartId, item);
    }

    @Override
    public List<Item> getCart(String cartId) {
        return (List<Item>)cartRedisRepository.getCart(cartId);
    }

    @Override
    public void changeItemQuantity(String cartId, Long productId, Integer quantity) {
        Collection<Item> cart_ = cartRedisRepository.getCart(cartId);
        List<Item> cart = new ArrayList<>();
        for (Item obj : cart_) {
            if (obj instanceof Item) {
                cart.add((Item) obj);
            }
        }
        for(Item item : cart){
            if((item.getProduct().getId()).equals(productId)){
                cartRedisRepository.deleteItemFromCart(cartId, item);
                item.setQuantity(quantity);
                item.setSubTotal(CartUtilities.getSubTotalForItem(item.getProduct(),quantity));
                cartRedisRepository.addItemToCart(cartId, item);
            }
        }
    }

    @Override
    public void deleteItemFromCart(String cartId, Long productId) {
        Collection<Item> cart_ = cartRedisRepository.getCart(cartId);
        List<Item> cart = new ArrayList<>();
        for (Item obj : cart_) {
            if (obj instanceof Item) {
                cart.add((Item) obj);
            }
        }
        for(Item item : cart){
            if((item.getProduct().getId()).equals(productId)){
                cartRedisRepository.deleteItemFromCart(cartId, item);
            }
        }
    }

    @Override
    public boolean checkIfItemIsExist(String cartId, Long productId) {
        Collection<Item> cart_ = cartRedisRepository.getCart(cartId);
        List<Item> cart = new ArrayList<>();
        for (Item obj : cart_) {
            if (obj instanceof Item) {
                cart.add((Item) obj);
            }
        }
        for(Item item : cart){
            if((item.getProduct().getId()).equals(productId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Item> getAllItemsFromCart(String cartId) {
        Collection<Item> cart_ = cartRedisRepository.getCart(cartId);
        List<Item> cart = new ArrayList<>();
        for (Item obj : cart_) {
            if (obj instanceof Item) {
                cart.add((Item) obj);
            }
        }
        return cart;
    }

    @Override
    public void deleteCart(String cartId) {
        cartRedisRepository.deleteCart(cartId);
    }
}
