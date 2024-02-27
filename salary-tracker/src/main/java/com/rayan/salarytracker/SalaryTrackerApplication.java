package com.rayan.salarytracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rayan.salarytracker.dao.BudgetDao;
import com.rayan.salarytracker.dao.CategoryDao;
import com.rayan.salarytracker.dao.SalaryDao;
import com.rayan.salarytracker.dao.UserDao;
import com.rayan.salarytracker.utility.OperationUtility;

@SpringBootApplication
public class SalaryTrackerApplication implements CommandLineRunner {

	@Autowired
	private UserDao userDao;
	@Autowired
	private SalaryDao salaryDao;
	@Autowired
	private BudgetDao budgetDao;
	@Autowired
	private CategoryDao categoryDao;

	public static void main(String[] args) {
		SpringApplication.run(SalaryTrackerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// OperationUtility.userOperations(userDao);
		// OperationUtility.salaryOperations(salaryDao, userDao);
		// OperationUtility.budgetOperations(budgetDao, salaryDao);
		// OperationUtility.categoryOperations(categoryDao, budgetDao);
	}
}
