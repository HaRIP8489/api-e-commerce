package com.example.apiecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // User thêm vào giỏ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Sản phẩm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Chủ sở hữu sản phẩm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column
    private Integer quantity = 1;

    @Column(name = "price_per_day", nullable = false)
    private Double pricePerDay;

    @Column(name = "rent_start")
    private LocalDate rentStart;

    @Column(name = "rent_end")
    private LocalDate rentEnd;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CartItem() {}

    public CartItem(Integer id, User user, Product product, User owner, Integer quantity, Double pricePerDay,
                    LocalDate rentStart, LocalDate rentEnd, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.owner = owner;
        this.quantity = quantity;
        this.pricePerDay = pricePerDay;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter & setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Double getPricePerDay() { return pricePerDay; }
    public void setPricePerDay(Double pricePerDay) { this.pricePerDay = pricePerDay; }
    public LocalDate getRentStart() { return rentStart; }
    public void setRentStart(LocalDate rentStart) { this.rentStart = rentStart; }
    public LocalDate getRentEnd() { return rentEnd; }
    public void setRentEnd(LocalDate rentEnd) { this.rentEnd = rentEnd; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @PrePersist
    protected void onCreate() { createdAt = updatedAt = LocalDateTime.now(); }
    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }
}
