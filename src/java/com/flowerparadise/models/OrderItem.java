package com.flowerparadise.models;

public class OrderItem {
    private int id;
    private int productId;
    private String productName;
    private int quantity;
    private double unitPrice;
    private String variant;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getUnitPrice() { return unitPrice; }
    public void setUnitPrice(double unitPrice) { this.unitPrice = unitPrice; }
    public String getVariant() { return variant; }
    public void setVariant(String variant) { this.variant = variant; }
}