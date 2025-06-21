package com.example.apiecommerce.controller.owner;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner/orders")
@PreAuthorize("hasRole('own')")
public class ShopOrderController {

    @GetMapping
    public String getShopOrders() {
        return "Own: Xem đơn hàng của shop";
    }

    // ... các API quản lý đơn hàng của shop
}
