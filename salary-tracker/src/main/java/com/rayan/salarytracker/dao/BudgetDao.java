package com.rayan.salarytracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rayan.salarytracker.entity.Budget;

public interface BudgetDao extends JpaRepository<Budget, Long> {

    @Query(value = "SELECT * FROM budget WHERE salary_id =:salaryId", nativeQuery = true)
    List<Budget> getBudgetsBySalaryId(@Param("salaryId") Long salaryId);
}
