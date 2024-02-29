package com.rayan.salarytracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rayan.salarytracker.dao.BudgetSummaryDao;
import com.rayan.salarytracker.entity.BudgetSummary;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BudgetSummaryService {

    private BudgetSummaryDao budgetSummaryDao;

    public BudgetSummaryService(BudgetSummaryDao budgetSummaryDao) {
        this.budgetSummaryDao = budgetSummaryDao;
    }

    public BudgetSummary findAllBySalaryId(Long salaryId) {
        return budgetSummaryDao.findBySalaryId(salaryId);
    }

}
