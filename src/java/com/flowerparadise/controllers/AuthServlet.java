package com.flowerparadise.controllers;

import services.UserService;
import com.flowerparadise.models.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AuthServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("login".equals(action)) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = userService.login(email, password);
            if (user != null) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("home.jsp");
            } else {
                req.setAttribute("error", "Login gagal");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else if ("register".equals(action)) {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = userService.register(name, email, password);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("home.jsp");
        }
    }
}
