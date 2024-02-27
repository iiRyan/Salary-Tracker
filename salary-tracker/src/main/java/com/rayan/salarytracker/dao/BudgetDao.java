package com.rayan.salarytracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayan.salarytracker.entity.Budget;

public interface BudgetDao extends JpaRepository<Budget, Long> {

}
