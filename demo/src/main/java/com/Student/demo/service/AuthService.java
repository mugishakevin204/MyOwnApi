package com.Student.demo.service;

import com.Student.demo.model.User;

public interface AuthService {
    User register(User user);
    String login(String username, String password);
}
