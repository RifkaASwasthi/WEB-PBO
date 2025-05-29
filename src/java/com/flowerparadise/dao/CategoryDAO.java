package com.flowerparadise.dao;

import com.flowerparadise.models.Category;
import java.sql.*;
import java.util.*;
import com.flowerparadise.utils.DatabaseUtil;

public class CategoryDAO {

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM categories");
            while (rs.next()) {
                categories.add(mapResultSet(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    private Category mapResultSet(ResultSet rs) throws SQLException {
        Category c = new Category();
        c.setId(rs.getInt("id"));
        c.setName(rs.getString("name"));
        c.setDescription(rs.getString("description"));
        c.setIcon(rs.getString("icon"));
        c.setSlug(rs.getString("slug"));
        return c;
    }
}
