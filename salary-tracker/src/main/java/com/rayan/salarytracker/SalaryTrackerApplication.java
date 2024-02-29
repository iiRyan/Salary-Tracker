package com.rayan.salarytracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rayan.salarytracker.dao.BudgetDao;
import com.rayan.salarytracker.dao.CategoryDao;
import com.rayan.salarytracker.dao.SalaryDao;
import com.rayan.salarytracker.dao.UserDao;
import com.rayan.salarytracker.entity.Budget;
import com.rayan.salarytracker.entity.Category;
import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.entity.User;
import com.rayan.salarytracker.service.BudgetService;
import com.rayan.salarytracker.service.CategoryService;
import com.rayan.salarytracker.service.SalaryService;
import com.rayan.salarytracker.service.UserService;
import com.rayan.salarytracker.utility.OperationUtility;

@SpringBootApplication
public class SalaryTrackerApplication {

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

	// @Bean
	// CommandLineRunner start(UserService userService, SalaryService salaryService,
	// BudgetService budgetService,
	// CategoryService categoryService) {
	// return args -> {

	// User user = userService.createUser("Rayan", "rayan@gmail.com", "pass1");
	// User user1 = userService.createUser("jojo", "jojo@gmail.com", "pass1");

	// Salary salary = salaryService.createSalary(20000, "November", user1);
	// Salary salary1 = salaryService.createSalary(12450, "March", user);

	// Budget budget = budgetService.createBudget(500, "Rent", true, "STCPay",
	// salary1);
	// Budget budget2 = budgetService.createBudget(6000, "Bank", true, "STCPay",
	// salary);
	// Budget budget3 = budgetService.createBudget(458, "Bank", true, "STCPay",
	// salary);
	// Budget budget4 = budgetService.createBudget(6000, "Bank", true, "STCPay",
	// salary);
	// Budget budget5 = budgetService.createBudget(6000, "Bank", true, "STCPay",
	// salary);

	// Category category = categoryService.createCategory("Personal", budget2);
	// Category category1 = categoryService.createCategory("Random Expenses",
	// budget);

	// };
	// }

}
