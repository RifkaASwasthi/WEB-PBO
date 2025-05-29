package com.flowerparadise.services;

import com.flowerparadise.models.Order;
import com.flowerparadise.models.User;
import java.util.List;
import java.util.ArrayList;

public class OrderService {
    private static final List<Order> orders = new ArrayList<>();
    
    public Order createOrder(User user, List<String> items, double total) {
        Order order = new Order(orders.size() + 1, user.getId(), items, total);
        orders.add(order);
        return order;
    }
    
    public List<Order> getOrdersByUser(int userId) {
        List<Order> result = new ArrayList<>();
        for (Order order : orders) {
            if (order.getUserId() == userId) {
                result.add(order);
            }
        }
        return result;
    }
}