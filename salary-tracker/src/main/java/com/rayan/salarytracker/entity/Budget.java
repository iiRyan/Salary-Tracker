package com.rayan.salarytracker.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "budget")
public class Budget {

    /* Begin fields */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "budget_id", nullable = false)
    private Long budgetId;

    @Basic
    @Column(name = "budget_amount", nullable = true, precision = 10)
    private double budgetAmount;

    @Basic
    @Column(name = "budget_description", nullable = true, length = 80)
    private String budgetDescription;

    @Basic
    @Column(name = "budget_status", nullable = true)
    private boolean budgetStatus;
    /* Ends fields */

    /* Begin Relationships */
    @ManyToOne
    @JoinColumn(name = "salary_id", referencedColumnName = "salary_id", nullable = false)
    private Salary salary;

    @OneToMany(mappedBy = "budget", fetch = FetchType.LAZY)
    private List<Category> categoryList;
    /* Ends Relationships */

    public Budget() {
    }

    public Budget(double budgetAmount, String budgetDescription, boolean budgetStatus, Salary salary) {
        this.budgetAmount = budgetAmount;
        this.budgetDescription = budgetDescription;
        this.budgetStatus = budgetStatus;
        this.salary = salary;
    }

    public Long getBudgetId() {
        return this.budgetId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public double getBudgetAmount() {
        return this.budgetAmount;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public String getBudgetDescription() {
        return this.budgetDescription;
    }

    public void setBudgetDescription(String budgetDescription) {
        this.budgetDescription = budgetDescription;
    }

    public boolean isBudgetStatus() {
        return this.budgetStatus;
    }

    public boolean getBudgetStatus() {
        return this.budgetStatus;
    }

    public void setBudgetStatus(boolean budgetStatus) {
        this.budgetStatus = budgetStatus;
    }

    @Override
    public String toString() {
        return "Budget [budgetId=" + budgetId + ", budgetAmount=" + budgetAmount + ", budgetDescription="
                + budgetDescription + ", budgetStatus=" + budgetStatus + "]";
    }

    public Salary getSalary() {
        return this.salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public void add(Category tempCategory) {
        if (categoryList == null) {
            categoryList = new ArrayList<>();
        }
        categoryList.add(tempCategory);
        tempCategory.setBudget(this);
    }
}
