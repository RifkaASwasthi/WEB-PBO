package com.flowerparadise.models;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private String orderNumber;
    private int userId;
    private double totalAmount;
    private String status;
    private Date createdAt;
    private String billingAddress;
    private String paymentMethod;
    private List<OrderItem> items;
    
    // Default constructor
    public Order() {
        this.items = new ArrayList<>();
        this.createdAt = new Date();
        this.status = "PENDING";
    }
    
    // Constructor with essential fields
    public Order(String orderNumber, int userId, double totalAmount, String billingAddress, String paymentMethod) {
        this();
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.billingAddress = billingAddress;
        this.paymentMethod = paymentMethod;
    }
    
    // Full constructor
    public Order(int orderId, String orderNumber, int userId, double totalAmount, 
                 String status, Date createdAt, String billingAddress, String paymentMethod) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
        this.billingAddress = billingAddress;
        this.paymentMethod = paymentMethod;
        this.items = new ArrayList<>();
    }
    
    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderNumber() {
        return orderNumber;
    }
    
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    
    public String getBillingAddress() {
        return billingAddress;
    }
    
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public List<OrderItem> getItems() {
        return items;
    }
    
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
    
    // Utility methods
    public void addItem(OrderItem item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(item);
    }
    
    public void removeItem(OrderItem item) {
        if (this.items != null) {
            this.items.remove(item);
        }
    }
    
    public int getItemCount() {
        return this.items != null ? this.items.size() : 0;
    }
    
    public double calculateTotalAmount() {
        if (this.items == null || this.items.isEmpty()) {
            return 0.0;
        }
        
        double total = 0.0;
        for (OrderItem item : this.items) {
            total += item.getUnitPrice() * item.getQuantity();
        }
        this.totalAmount = total;
        return total;
    }
    
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNumber='" + orderNumber + '\'' +
                ", userId=" + userId +
                ", totalAmount=" + totalAmount +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", billingAddress='" + billingAddress + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", itemCount=" + getItemCount() +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Order order = (Order) o;
        return orderId == order.orderId;
    }
    
    @Override
    public int hashCode() {
        return orderId;
    }
}