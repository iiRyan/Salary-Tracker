package com.rayan.salarytracker.service;

import java.util.List;

import com.rayan.salarytracker.entity.Budget;
import com.rayan.salarytracker.entity.Category;

public interface CategoryService {

    Category loadCategoryById(Long CategoryId);

    Category createCategory(String categoryName, Budget budget);

    Category createOrUpdateCategory(Category category);

    List<Category> fetchAll();

    void removeCategory(Long categoryId);
}
