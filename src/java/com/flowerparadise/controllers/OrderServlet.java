package com.flowerparadise.controllers;

import services.OrderService;
import com.flowerparadise.models.Order;
import com.flowerparadise.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

public class OrderServlet extends HttpServlet {
    private final OrderService orderService = new OrderService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String[] items = req.getParameterValues("items");
        double total = Double.parseDouble(req.getParameter("total"));

        Order order = orderService.createOrder(user, Arrays.asList(items), total);
        req.setAttribute("order", order);
        req.getRequestDispatcher("order-confirmation.jsp").forward(req, resp);
    }
}
