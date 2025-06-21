package com.example.apiecommerce.controller.owner;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner/products")
@PreAuthorize("hasRole('own')")
public class ShopProductController {

    @GetMapping
    public String getMyProducts() {
        return "Own: Xem danh sách sản phẩm của shop mình";
    }

    @PostMapping
    public String addProduct() {
        return "Own: Thêm sản phẩm mới";
    }
    // ... các API quản lý sản phẩm của riêng shop
}
