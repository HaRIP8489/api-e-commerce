package com.example.apiecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product_details")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "brand_id")
    private Integer brandId;

    @Column
    private String model;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "product_condition")
    private String productCondition;

    @Column
    private String accessories;

    @Column
    private Double weight;

    @Column
    private String color;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ProductDetail() {}

    // Constructor đầy đủ
    public ProductDetail(Integer id, Product product, String description, Integer brandId, String model,
                         Integer categoryId, String productCondition, String accessories,
                         Double weight, String color, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.product = product;
        this.description = description;
        this.brandId = brandId;
        this.model = model;
        this.categoryId = categoryId;
        this.productCondition = productCondition;
        this.accessories = accessories;
        this.weight = weight;
        this.color = color;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter & Setter (bạn có thể generate bằng IDE cho nhanh)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getBrandId() { return brandId; }
    public void setBrandId(Integer brandId) { this.brandId = brandId; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public String getProductCondition() { return productCondition; }
    public void setProductCondition(String productCondition) { this.productCondition = productCondition; }
    public String getAccessories() { return accessories; }
    public void setAccessories(String accessories) { this.accessories = accessories; }
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @PrePersist
    protected void onCreate() { createdAt = updatedAt = LocalDateTime.now(); }

    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }
}
