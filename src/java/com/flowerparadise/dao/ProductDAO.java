package com.flowerparadise.dao;

import com.flowerparadise.models.Product;
import java.sql.*;
import java.util.*;
import com.flowerparadise.utils.DatabaseUtil;

public class ProductDAO {

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM products");
            while (rs.next()) {
                products.add(mapResultSet(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product findById(int id) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM products WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return mapResultSet(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Product mapResultSet(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setName(rs.getString("name"));
        p.setDescription(rs.getString("description"));
        p.setPrice(rs.getDouble("price"));
        p.setSalePrice(rs.getDouble("sale_price"));
        p.setCategoryId(rs.getInt("category_id"));
        p.setOccasion(rs.getString("occasion"));
        p.setRating(rs.getDouble("rating"));
        p.setReviews(rs.getInt("reviews"));
        p.setStock(rs.getInt("stock"));
        p.setImage(rs.getString("image"));
        p.setBadge(rs.getString("badge"));
        return p;
    }
}
