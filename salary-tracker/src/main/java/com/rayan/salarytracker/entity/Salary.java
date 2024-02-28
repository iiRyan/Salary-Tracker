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
@Table(name = "salary")
public class Salary {

    /* Begin fields */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id", nullable = false)
    private Long salaryId;

    @Basic
    @Column(name = "salary", nullable = false, precision = 10)
    private int salary;

    @Basic
    @Column(name = "salary_month", nullable = false, length = 10)
    private String salaryMonth;
    /* Ends fields */

    /* Begin Relationships */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "salary")
    private List<Budget> budgetList;
    /* Ends Relationships */

    public Salary() {
    }

    public Salary(int salary, String salaryMonth, User user) {
        this.salary = salary;
        this.salaryMonth = salaryMonth;
        this.user = user;
    }

    public Long getSalaryId() {
        return this.salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSalaryMonth() {
        return this.salaryMonth;
    }

    public void setSalaryMonth(String salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    @Override
    public String toString() {
        return "Salary [salaryId=" + salaryId + ", salary=" + salary + ", salaryMonth=" + salaryMonth + "]";
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Budget> getBudgetList() {
        return this.budgetList;
    }

    public void setBudgetList(List<Budget> budgetList) {
        this.budgetList = budgetList;
    }

    public void add(Budget tempBudget) {
        if (budgetList == null) {
            budgetList = new ArrayList<>();
        }

        budgetList.add(tempBudget);
        tempBudget.setSalary(this);
    }
}
