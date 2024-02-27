package com.rayan.salarytracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayan.salarytracker.entity.User;
import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {

    User findByUserEmail(String userEmail);

}
