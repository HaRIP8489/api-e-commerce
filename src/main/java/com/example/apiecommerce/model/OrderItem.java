package com.example.apiecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Thuộc về đơn hàng nào
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    // Sản phẩm nào
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    // Chủ sản phẩm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column
    private Integer quantity;

    @Column(name = "price_per_day")
    private Double pricePerDay;

    @Column(name = "rent_start")
    private LocalDate rentStart;

    @Column(name = "rent_end")
    private LocalDate rentEnd;

    @Column(name = "total_price")
    private Double totalPrice;

    public OrderItem() {}

    public OrderItem(Integer id, Order order, Product product, User owner, Integer quantity,
                     Double pricePerDay, LocalDate rentStart, LocalDate rentEnd, Double totalPrice) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.owner = owner;
        this.quantity = quantity;
        this.pricePerDay = pricePerDay;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
        this.totalPrice = totalPrice;
    }

    // Getter/setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
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
    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
}
