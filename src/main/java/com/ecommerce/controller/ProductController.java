package com.ecommerce.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.services.CartService;

import jakarta.annotation.PostConstruct;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartService cartService;

    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products"; // maps to products.html
    }

    @GetMapping("/admin/add-product")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add_product"; // maps to add_product.html
    }

    @PostMapping("/admin/add-product")
    public String addProduct(Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        return "cart"; // maps to cart.html
    }

    @GetMapping("/add-to-cart")
    public String addToCart(@RequestParam Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            cartService.addToCart(product);
        }
        return "redirect:/products";
    }
    
    @GetMapping("/admin/delete-product")
    public String deleteProduct(@RequestParam Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
    
    @PostConstruct
    public void init() {
        if (productRepository.count() == 0) {
            List<Product> products = Arrays.asList(
                new Product("iPhone 15", "Apple iPhone 15 smartphone", 999.99),
                new Product("Samsung Galaxy S24", "Flagship Android phone", 899.99),
                new Product("MacBook Air M3", "Apple's lightweight laptop", 1299.00),
                new Product("Dell XPS 15", "High-performance Windows laptop", 1399.00),
                new Product("Sony WH-1000XM5", "Noise-cancelling headphones", 399.99)
            );
            productRepository.saveAll(products);
        }
    }
}
