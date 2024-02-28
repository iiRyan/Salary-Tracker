package com.rayan.salarytracker.service;

import java.util.List;

import com.rayan.salarytracker.entity.Budget;
import com.rayan.salarytracker.entity.Salary;

public interface BudgetService {
    Budget loadBudgetById(Long budgetId);

    Budget createBudget(int budgetAmount, String budgetDescription, boolean budgetStatus, String bankAccount,
            Salary salary);

    Budget createOrUpdateBudget(Budget budget);

    List<Budget> fetchAll();

    List<Budget> getBudgetsBySalaryId(Long salaryId);

    void removeBudget(Long budgetId);

}
