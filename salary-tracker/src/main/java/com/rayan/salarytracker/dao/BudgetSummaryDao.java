package com.rayan.salarytracker.dao;

import com.rayan.salarytracker.entity.BudgetSummary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BudgetSummaryDao extends JpaRepository<BudgetSummary, Long> {

    @Query(value = "SELECT s.salary_id AS salary_id, COALESCE(SUM(b.budget_amount), 0) AS total_expenses, (s.salary - COALESCE(SUM(b.budget_amount), 0)) AS remaining_salary FROM salary s LEFT JOIN budget b ON s.salary_id = b.salary_id WHERE s.salary_id =:salaryId GROUP BY s.salary_id,s.salary", nativeQuery = true)
    BudgetSummary findBySalaryId(@Param("salaryId") Long salaryId);

}
