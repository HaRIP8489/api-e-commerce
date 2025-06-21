package com.example.apiecommerce.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/products")
@PreAuthorize("hasRole('admin')")
public class AdminProductController {

    @GetMapping
    public String listAllProducts() {
        return "Admin: Xem tất cả sản phẩm trên hệ thống";
    }

    // ... các API quản lý sản phẩm hệ thống
}
