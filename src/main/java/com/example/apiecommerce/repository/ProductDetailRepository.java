package com.example.apiecommerce.repository;

import com.example.apiecommerce.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    Optional<ProductDetail> findByProductId(Integer productId);
}
