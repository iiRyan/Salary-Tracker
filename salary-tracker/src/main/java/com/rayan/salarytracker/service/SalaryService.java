package com.rayan.salarytracker.service;

import java.util.List;

import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.entity.User;

public interface SalaryService {
    Salary loadSalaryById(Long salaryId);

    Salary createSalary(double salary, String salaryMonth, User user);

    Salary updateSalary(Salary salary);

    List<Salary> fetchSalaries();

    void removeSalary(Long salaryId);
}
