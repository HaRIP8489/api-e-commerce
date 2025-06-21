package com.example.apiecommerce.controller.customer;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/profile")
@PreAuthorize("hasAnyRole('guest','own','admin')")
public class CustomerProfileController {

    @GetMapping
    public String getProfile() {
        return "Customer: Xem profile cá nhân";
    }
}
