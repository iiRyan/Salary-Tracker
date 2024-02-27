package com.rayan.salarytracker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rayan.salarytracker.dao.BudgetDao;
import com.rayan.salarytracker.entity.Budget;
import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.service.BudgetService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class BudgetServiceImpl implements BudgetService {

    private BudgetDao budgetDao;

    public BudgetServiceImpl(BudgetDao budgetDao) {
        this.budgetDao = budgetDao;
    }

    @Override
    public Budget loadBudgetById(Long budgetId) {
        return budgetDao.findById(budgetId)
                .orElseThrow(() -> new EntityNotFoundException("Budget with Id ==> " + budgetId + " Not Found!"));

    }

    @Override
    public Budget createBudget(double budgetAmount, String budgetDescription, boolean budgetStatus, String bankAccount,
            Salary salary) {
        return budgetDao.save(new Budget(budgetAmount, budgetDescription, budgetStatus, bankAccount, salary));
    }

    @Override
    public Budget createOrUpdateBudget(Budget budget) {
        return budgetDao.save(budget);
    }

    @Override
    public List<Budget> fetchAll() {
        return budgetDao.findAll();
    }

    @Override
    public void removeBudget(Long budgetId) {
        budgetDao.deleteById(budgetId);
    }

}
