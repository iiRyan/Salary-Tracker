package com.rayan.salarytracker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rayan.salarytracker.dao.CategoryDao;
import com.rayan.salarytracker.entity.Budget;
import com.rayan.salarytracker.entity.Category;
import com.rayan.salarytracker.service.CategoryService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category loadCategoryById(Long categoryId) {
        return categoryDao.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category with Id ==> " + categoryId + " Not Found!"));

    }

    @Override
    public Category createCategory(String categoryName, Budget budget) {
        return categoryDao.save(new Category(categoryName, budget));
    }

    @Override
    public Category createOrUpdateCategory(Category category) {
        return categoryDao.save(category);
    }

    @Override
    public List<Category> fetchAll() {
        return categoryDao.findAll();
    }

    @Override
    public void removeCategory(Long categoryId) {
        categoryDao.deleteById(categoryId);
    }

}
