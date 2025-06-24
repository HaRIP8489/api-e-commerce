package com.example.apiecommerce.dto;

import com.example.apiecommerce.model.Product;
import com.example.apiecommerce.model.ProductDetail;

public class ProductDetailDTO {
    private Product product;
    private ProductDetail detail;

    public ProductDetailDTO(Product product, ProductDetail detail) {
        this.product = product;
        this.detail = detail;
    }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public ProductDetail getDetail() { return detail; }
    public void setDetail(ProductDetail detail) { this.detail = detail; }
}
