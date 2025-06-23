package com.example.apiecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Người thuê (người mua)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "renter_id", nullable = false)
    private User renter;

    // Chủ sản phẩm (shop)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "total_price")
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.pending;

    @Column(name = "rent_start")
    private LocalDate rentStart;

    @Column(name = "rent_end")
    private LocalDate rentEnd;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public enum Status {
        pending, confirmed, cancelled, completed
    }

    public Order() {}

    public Order(Integer id, User renter, User owner, Double totalPrice, Status status,
                 LocalDate rentStart, LocalDate rentEnd,
                 LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.renter = renter;
        this.owner = owner;
        this.totalPrice = totalPrice;
        this.status = status;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter/setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public User getRenter() { return renter; }
    public void setRenter(User renter) { this.renter = renter; }
    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }
    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public LocalDate getRentStart() { return rentStart; }
    public void setRentStart(LocalDate rentStart) { this.rentStart = rentStart; }
    public LocalDate getRentEnd() { return rentEnd; }
    public void setRentEnd(LocalDate rentEnd) { this.rentEnd = rentEnd; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

    @PrePersist
    protected void onCreate() { createdAt = updatedAt = LocalDateTime.now(); }
    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }
}
