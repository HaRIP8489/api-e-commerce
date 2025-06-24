package com.example.apiecommerce.repository;

import com.example.apiecommerce.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    Optional<CartItem> findByUserIdAndProductId(Long userId, Integer productId);
    List<CartItem> findByUserId(Long userId);
}
