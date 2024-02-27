package com.rayan.salarytracker.service.impl;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rayan.salarytracker.dao.UserDao;
import com.rayan.salarytracker.entity.User;
import com.rayan.salarytracker.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User loadUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User createUser(String userName, String userEmail, String userPassword) {
        User user = loadUserByEmail(userEmail);

        // Check if the email already exist
        if (user != null) {
            throw new RuntimeException("User with email: " + userEmail + " already exist");
        }
        return userDao.save(new User(userName, userEmail, userPassword));
    }

}
