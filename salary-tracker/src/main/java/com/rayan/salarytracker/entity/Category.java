package com.rayan.salarytracker.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    /* Begin fields */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Basic
    @Column(name = "category_name", nullable = true, length = 50)
    private String categoryName;
    /* Begin fields */

    /* Begin Relationships */
    @ManyToOne
    @JoinColumn(name = "budget_id", referencedColumnName = "budget_id", nullable = false)
    private Budget budget;
    /* Ends Relationships */

    public Category() {
    }

    public Category(String categoryName, Budget budget) {
        this.categoryName = categoryName;
        this.budget = budget;
    }

    public Long getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "{" +
                " categoryId='" + getCategoryId() + "'" +
                ", categoryName='" + getCategoryName() + "'" +
                "}";
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

}
