package com.rayan.salarytracker.service;

import com.rayan.salarytracker.entity.User;

public interface UserService {
    User loadUserByEmail(String email);

    User findByUserId(Long userId);

    User createUser(String userName, String userEmail, String userPassword);
}
