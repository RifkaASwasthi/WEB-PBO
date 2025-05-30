package com.flowerparadise.dao;

import com.flowerparadise.models.User;
import java.sql.*;
import java.util.*;
import com.flowerparadise.utils.DatabaseUtil;

public class UserDAO {

    public User findByEmailAndPassword(String email, String password) {
        User user = null;
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?")) {
            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                user = mapResultSet(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean insert(User user) {
        String sql = "INSERT INTO users(full_name, email, phone, password, is_active) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getFullName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhone());
            stmt.setString(4, user.getPassword());
            stmt.setBoolean(5, user.isActive());
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private User mapResultSet(ResultSet rs) throws SQLException {
        User u = new User();
        u.setId(rs.getInt("id"));
        u.setFullName(rs.getString("full_name"));
        u.setEmail(rs.getString("email"));
        u.setPhone(rs.getString("phone"));
        u.setPassword(rs.getString("password"));
        u.setActive(rs.getBoolean("is_active"));
        return u;
    }
}
