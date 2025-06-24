package com.example.apiecommerce.dto;

public class AddToCartRequest {
    private Integer productId;
    private Integer quantity;
    private String rentStart; // định dạng yyyy-MM-dd
    private String rentEnd;

    public AddToCartRequest() {}

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getRentStart() { return rentStart; }
    public void setRentStart(String rentStart) { this.rentStart = rentStart; }

    public String getRentEnd() { return rentEnd; }
    public void setRentEnd(String rentEnd) { this.rentEnd = rentEnd; }
}
