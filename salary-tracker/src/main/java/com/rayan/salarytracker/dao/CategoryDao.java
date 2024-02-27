package com.rayan.salarytracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayan.salarytracker.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
