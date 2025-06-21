package com.example.apiecommerce.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/users")
@PreAuthorize("hasRole('admin')")
public class AdminUserController {

    @GetMapping
    public String listUsers() {
        return "Admin: Xem danh sách tất cả user";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        return "Admin: Xóa user có id " + id;
    }
    // Thêm các API quản trị user khác tại đây
}
