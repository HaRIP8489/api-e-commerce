package com.example.apiecommerce.controller.customer;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer/orders")
@PreAuthorize("hasAnyRole('guest','own','admin')")
public class CustomerOrderController {

    @GetMapping
    public String getMyOrders() {
        return "Customer: Xem đơn hàng của mình";
    }
}
