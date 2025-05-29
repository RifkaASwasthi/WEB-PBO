package com.flowerparadise.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItemById(int id) {
        items.removeIf(item -> item.getId() == id);
    }

    public double getTotal() {
        return items.stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }
}
