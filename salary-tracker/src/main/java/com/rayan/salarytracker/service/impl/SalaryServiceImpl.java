package com.rayan.salarytracker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rayan.salarytracker.dao.SalaryDao;
import com.rayan.salarytracker.entity.Budget;
import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.entity.User;
import com.rayan.salarytracker.service.BudgetService;
import com.rayan.salarytracker.service.SalaryService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {

    private SalaryDao salaryDao;
    private BudgetService budgetService;

    public SalaryServiceImpl(SalaryDao salaryDao, BudgetService budgetService) {
        this.salaryDao = salaryDao;
        this.budgetService = budgetService;
    }

    @Override
    public Salary loadSalaryById(Long salaryId) {
        return salaryDao.findById(salaryId)
                .orElseThrow(() -> new EntityNotFoundException("Salary with Id ==> " + salaryId + " Not Found!"));
    }

    @Override
    public Salary createSalary(int salary, String salaryMonth, User user) {
        return salaryDao.save(new Salary(salary, salaryMonth, user));
    }

    @Override
    public Salary updateSalary(Salary salary) {
        return salaryDao.save(salary);
    }

    @Override
    public List<Salary> fetchSalaries() {
        return salaryDao.findAll();
    }

    @Override
    public void removeSalary(Long salaryId) {
        // You have to delete the Budgets associated with the salary first.
        Salary salary = loadSalaryById(salaryId);
        for (Budget budget : salary.getBudgetList()) {
            budgetService.removeBudget(budget.getBudgetId());
        }
        salaryDao.deleteById(salaryId);
    }

}
