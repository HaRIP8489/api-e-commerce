package com.example.apiecommerce.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/public/products")
public class PublicProductController {

    @GetMapping
    public String listPublicProducts() {
        return "Ai cũng xem được danh sách sản phẩm public";
    }
}
