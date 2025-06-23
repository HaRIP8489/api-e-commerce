package com.example.apiecommerce.service;

import com.example.apiecommerce.model.Product;
import com.example.apiecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Lấy tất cả sản phẩm hoặc theo status
    public List<Product> getAllAvailableProducts() {
        return productRepository.findByStatus(Product.Status.available);
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }
}
