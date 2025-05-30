package com.flowerparadise.services;

import com.flowerparadise.models.Product;
import java.util.*;

public class ProductService {
    private static final List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Red Rose Bouquet Deluxe", "24 mawar merah segar", 450000, 380000, "Love & Romance", "🌹", 25));
        products.add(new Product(2, "Sunflower Happiness", "Rangkaian bunga matahari cerah", 285000, 0, "Get Well Soon", "🌻", 18));
        products.add(new Product(3, "Wedding Dream Bouquet", "Lily & baby breath", 750000, 650000, "Wedding", "💒", 12));
        products.add(new Product(4, "Birthday Surprise Mix", "Campuran bunga ceria", 320000, 275000, "Birthday", "🎈", 31));
        products.add(new Product(5, "Peaceful White Lilies", "Rangkaian lily putih", 420000, 0, "Sympathy", "🕊️", 15));
        products.add(new Product(6, "Success Celebration", "Buket untuk pencapaian", 525000, 475000, "Congratulations", "🏆", 20));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> filtered = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                filtered.add(p);
            }
        }
        return filtered;
    }

    public Product getProductById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}
