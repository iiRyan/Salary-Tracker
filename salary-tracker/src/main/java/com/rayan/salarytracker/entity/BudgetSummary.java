package com.rayan.salarytracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BudgetSummary {

    @Id
    @Column(name = "salary_id", nullable = false)
    private Long salaryId;

    @Column(name = "total_expenses")
    private int totalExpenses;

    @Column(name = "remaining_salary")
    private int remainingSalary;

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public int getRemainingSalary() {
        return remainingSalary;
    }

    public void setRemainingSalary(int remainingSalary) {
        this.remainingSalary = remainingSalary;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

}
