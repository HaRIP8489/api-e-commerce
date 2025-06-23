package com.example.apiecommerce.controller;

import java.util.List;
import com.example.apiecommerce.model.Product;
import com.example.apiecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/products")
public class PublicProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllAvailableProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id " + id));
    }
}
