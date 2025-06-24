package com.example.apiecommerce.controller;

import com.example.apiecommerce.dto.AddToCartRequest;
import com.example.apiecommerce.dto.CartItemResponse;
import com.example.apiecommerce.model.CartItem;
import com.example.apiecommerce.model.User;
import com.example.apiecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CartItemResponse addToCart(
            @AuthenticationPrincipal User user,
            @RequestBody AddToCartRequest request) {
        return cartService.addToCart(user, request); // Đã trả về DTO
    }

    @GetMapping
    public List<CartItemResponse> viewCart(@AuthenticationPrincipal User user) {
        return cartService.getCartItems(user);
    }
}
