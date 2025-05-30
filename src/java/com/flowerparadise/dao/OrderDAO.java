package com.flowerparadise.dao;

import com.flowerparadise.models.Order;
import com.flowerparadise.models.OrderItem;
import java.sql.*;
import java.util.*;
import com.flowerparadise.utils.DatabaseUtil;

public class OrderDAO {

    public boolean insert(Order order) {
        try (Connection conn = DatabaseUtil.getConnection()) {
            conn.setAutoCommit(false);

            String sqlOrder = "INSERT INTO orders (order_number, user_id, total_amount, status, created_at, billing_address, payment_method) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sqlOrder, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, order.getOrderNumber());
                stmt.setInt(2, order.getUserId());
                stmt.setDouble(3, order.getTotalAmount());
                stmt.setString(4, order.getStatus());
                stmt.setTimestamp(5, new Timestamp(order.getCreatedAt().getTime()));
                stmt.setString(6, order.getBillingAddress());
                stmt.setString(7, order.getPaymentMethod());
                stmt.executeUpdate();

                ResultSet keys = stmt.getGeneratedKeys();
                if (keys.next()) {
                    int orderId = keys.getInt(1);
                    insertOrderItems(conn, orderId, order.getItems());
                    conn.commit();
                    return true;
                }
            } catch (Exception e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void insertOrderItems(Connection conn, int orderId, List<OrderItem> items) throws SQLException {
        String sqlItem = "INSERT INTO order_items (order_id, product_id, product_name, quantity, unit_price, variant) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sqlItem)) {
            for (OrderItem item : items) {
                stmt.setInt(1, orderId);
                stmt.setInt(2, item.getProductId());
                stmt.setString(3, item.getProductName());
                stmt.setInt(4, item.getQuantity());
                stmt.setDouble(5, item.getUnitPrice());
                stmt.setString(6, item.getVariant());
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
    }
}
