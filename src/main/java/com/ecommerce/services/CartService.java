package com.ecommerce.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ecommerce.model.Product;

@Service
public class CartService {
	private Map<Long, Product> cart = new HashMap<>();

    public void addToCart(Product product) {
        cart.put(product.getId(), product);
    }

    public Collection<Product> getCartItems() {
        return cart.values();
    }

    public void clearCart() {
        cart.clear();
    }
}
