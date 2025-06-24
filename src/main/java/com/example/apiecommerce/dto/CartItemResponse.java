package com.example.apiecommerce.dto;

public class CartItemResponse {
    private Integer id;
    private Integer productId;
    private String productName;
    private Integer ownerId;
    private String ownerUsername;
    private Integer quantity;
    private Double pricePerDay;
    private String rentStart;
    private String rentEnd;

    public CartItemResponse() {}

    public CartItemResponse(Integer id, Integer productId, String productName, Integer ownerId, String ownerUsername,
                            Integer quantity, Double pricePerDay, String rentStart, String rentEnd) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.ownerId = ownerId;
        this.ownerUsername = ownerUsername;
        this.quantity = quantity;
        this.pricePerDay = pricePerDay;
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public Integer getProductId() {return productId;}

    public void setProductId(Integer productId) {this.productId = productId;}

    public String getProductName() {return productName;}

    public void setProductName(String productName) {this.productName = productName;}

    public Integer getOwnerId() {return ownerId;}

    public void setOwnerId(Integer ownerId) {this.ownerId = ownerId;}

    public String getOwnerUsername() {return ownerUsername;}

    public void setOwnerUsername(String ownerUsername) {this.ownerUsername = ownerUsername;}

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public Double getPricePerDay() {return pricePerDay;}

    public void setPricePerDay(Double pricePerDay) {this.pricePerDay = pricePerDay;}

    public String getRentStart() {return rentStart;}

    public void setRentStart(String rentStart) {this.rentStart = rentStart;}

    public String getRentEnd() {return rentEnd;}

    public void setRentEnd(String rentEnd) {this.rentEnd = rentEnd;}
}
