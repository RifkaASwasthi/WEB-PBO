package com.flowerparadise.services;

import com.flowerparadise.models.User;
import java.util.*;

public class UserService {
    private static final List<User> users = new ArrayList<>();

    public User register(String name, String email, String password) {
        User user = new User(users.size() + 1, name, email, password);
        users.add(user);
        return user;
    }

    public User login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
