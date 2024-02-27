package com.rayan.salarytracker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rayan.salarytracker.entity.Salary;
import java.util.List;

public interface SalaryDao extends JpaRepository<Salary, Long> {

    List<Salary> findSalaryBySalaryMonthContains(String keyWord);

}
