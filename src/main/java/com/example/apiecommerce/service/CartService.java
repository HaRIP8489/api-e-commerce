package com.example.apiecommerce.service;

import com.example.apiecommerce.dto.AddToCartRequest;
import com.example.apiecommerce.dto.CartItemResponse;
import com.example.apiecommerce.model.*;
import com.example.apiecommerce.repository.CartItemRepository;
import com.example.apiecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private ProductRepository productRepository;

    public CartItemResponse addToCart(User user, AddToCartRequest request) {
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (request.getQuantity() == null || request.getQuantity() < 1)
            throw new RuntimeException("Quantity must be > 0");

        if (product.getQuantity() < request.getQuantity())
            throw new RuntimeException("Not enough product in stock");

        User owner = product.getOwner();
        if (owner == null) throw new RuntimeException("Owner not found");

        CartItem cartItem = cartItemRepository.findByUserIdAndProductId(user.getId(), product.getId())
                .orElse(null);

        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setUser(user);
            cartItem.setProduct(product);
            cartItem.setOwner(owner);
            cartItem.setCreatedAt(java.time.LocalDateTime.now());
            cartItem.setQuantity(request.getQuantity());
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
        }

        cartItem.setPricePerDay(product.getPricePerDay());
        cartItem.setUpdatedAt(java.time.LocalDateTime.now());

        if (request.getRentStart() != null && !request.getRentStart().isEmpty()) {
            cartItem.setRentStart(LocalDate.parse(request.getRentStart()));
        }
        if (request.getRentEnd() != null && !request.getRentEnd().isEmpty()) {
            cartItem.setRentEnd(LocalDate.parse(request.getRentEnd()));
        }

        CartItem savedItem = cartItemRepository.save(cartItem);

        return new CartItemResponse(
                savedItem.getId().intValue(),
                savedItem.getProduct().getId().intValue(),
                savedItem.getProduct().getName(),
                savedItem.getOwner().getId().intValue(),
                savedItem.getOwner().getUsername(),
                savedItem.getQuantity(),
                savedItem.getPricePerDay(),
                savedItem.getRentStart() != null ? savedItem.getRentStart().toString() : null,
                savedItem.getRentEnd() != null ? savedItem.getRentEnd().toString() : null
        );
    }

    public List<CartItemResponse> getCartItems(User user) {
        List<CartItem> items = cartItemRepository.findByUserId(user.getId());

        return items.stream().map(item -> new CartItemResponse(
                item.getId().intValue(),
                item.getProduct().getId().intValue(),
                item.getProduct().getName(),
                item.getOwner().getId().intValue(),
                item.getOwner().getUsername(),
                item.getQuantity(),
                item.getPricePerDay(),
                item.getRentStart() != null ? item.getRentStart().toString() : null,
                item.getRentEnd() != null ? item.getRentEnd().toString() : null
        )).collect(Collectors.toList());
    }
}
