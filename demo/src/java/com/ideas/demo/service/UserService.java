package com.ideas.demo.service;

import com.ideas.demo.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
