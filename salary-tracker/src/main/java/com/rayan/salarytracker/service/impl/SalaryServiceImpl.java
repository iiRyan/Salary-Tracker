package com.rayan.salarytracker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rayan.salarytracker.dao.SalaryDao;
import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.entity.User;
import com.rayan.salarytracker.service.SalaryService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class SalaryServiceImpl implements SalaryService {

    private SalaryDao salaryDao;

    public SalaryServiceImpl(SalaryDao salaryDao) {
        this.salaryDao = salaryDao;
    }

    @Override
    public Salary loadSalaryById(Long salaryId) {
        return salaryDao.findById(salaryId)
                .orElseThrow(() -> new EntityNotFoundException("Salary with Id ==> " + salaryId + " Not Found!"));
    }

    @Override
    public Salary createSalary(double salary, String salaryMonth, User user) {
        return salaryDao.save(new Salary(salary, salaryMonth, user));
    }

    @Override
    public Salary updateSalary(Salary salary) {
        return salaryDao.save(salary);
    }

    @Override
    public List<Salary> fetchSalaries() {
        return salaryDao.findAll();
    }

    @Override
    public void removeSalary(Long salaryId) {
        salaryDao.deleteById(salaryId);
    }

}
