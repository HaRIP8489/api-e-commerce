package com.example.apiecommerce.repository;

import com.example.apiecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByStatus(Product.Status status);
}
