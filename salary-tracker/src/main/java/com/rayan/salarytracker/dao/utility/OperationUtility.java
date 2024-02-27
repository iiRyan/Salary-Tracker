package com.rayan.salarytracker.dao.utility;

import com.rayan.salarytracker.dao.BudgetDao;
import com.rayan.salarytracker.dao.CategoryDao;
import com.rayan.salarytracker.dao.SalaryDao;
import com.rayan.salarytracker.dao.UserDao;
import com.rayan.salarytracker.entity.Budget;
import com.rayan.salarytracker.entity.Category;
import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.entity.User;

import jakarta.persistence.EntityNotFoundException;

public class OperationUtility {

    /* Begin User Operations */
    public static void userOperations(UserDao userDao) {
        // createUsers(userDao);
        // updateUser(userDao);
        // deleteUser(userDao);
        // fetchUsers(userDao);
    }

    private static void fetchUsers(UserDao userDao) {
        userDao.findAll().forEach(user -> System.out.println(user.toString()));
    }

    private static void deleteUser(UserDao userDao) {
        User user = userDao.findById(2L).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
        userDao.delete(user);
    }

    private static void updateUser(UserDao userDao) {
        User user = userDao.findById(2L).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
        user.setUserEmail("aljohara@gmail.com");
        userDao.save(user);
    }

    private static void createUsers(UserDao userDao) {

        User user = new User("Rayan", "rayan@gmail.com", "pass1");
        userDao.save(user);

        User user2 = new User("jojo", "jojo@gmail.com", "pass1");
        userDao.save(user2);

        User user3 = new User("Faisal", "faisal@gmail.com", "pass1");
        userDao.save(user3);
    }
    /* Ends User Operations */

    /* Begin User Salary Operations */
    public static void salaryOperations(SalaryDao salaryDao, UserDao userDao) {
        // createSalary(salaryDao, userDao);
        // updateSalary(salaryDao);
        // deleteSalary(salaryDao);
        // fetchAllSalary(salaryDao);
    }

    private static void fetchAllSalary(SalaryDao salaryDao) {
        salaryDao.findAll().forEach(salary -> System.out.println(salary.toString()));

    }

    private static void deleteSalary(SalaryDao salaryDao) {
        Salary salary = salaryDao.findById(2L).orElseThrow(() -> new EntityNotFoundException("Salary Not Found"));
        salaryDao.delete(salary);
    }

    private static void updateSalary(SalaryDao salaryDao) {
        Salary salary = salaryDao.findById(1L).orElseThrow(() -> new EntityNotFoundException("Salary Not Found"));
        salary.setSalary(14350.4);
        salaryDao.save(salary);

    }

    private static void createSalary(SalaryDao salaryDao, UserDao userDao) {

        User user = userDao.findById(1L).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
        Salary salary = new Salary(12000, "November", user);
        salaryDao.save(salary);

        User user2 = userDao.findById(3L).orElseThrow(() -> new EntityNotFoundException("User Not Found"));
        Salary salary2 = new Salary(111000, "December", user2);
        salaryDao.save(salary2);

        Salary salary3 = new Salary(12000, "March", user);
        salaryDao.save(salary3);
    }

    /* Ends User Salary Operations */

    /* Begin User Budget Operations */
    public static void budgetOperations(BudgetDao budgetDao, SalaryDao salaryDao) {
        // createBudget(budgetDao, salaryDao);
        // updateBudget(budgetDao);
        // deleteBudget(budgetDao);
        // fetchBudgets(budgetDao);
    }

    private static void fetchBudgets(BudgetDao budgetDao) {
        budgetDao.findAll().forEach(budget -> System.out.println(budget.toString()));

    }

    private static void deleteBudget(BudgetDao budgetDao) {
        Budget budget = budgetDao.findById(1L).orElseThrow(() -> new EntityNotFoundException("Budget Not Found"));
        budgetDao.delete(budget);
    }

    private static void updateBudget(BudgetDao budgetDao) {
        Budget budget = budgetDao.findById(1L).orElseThrow(() -> new EntityNotFoundException("Budget Not Found"));
        budget.setBudgetAmount(555.55);
        budgetDao.save(budget);
    }

    private static void createBudget(BudgetDao budgetDao, SalaryDao salaryDao) {
        Salary salary = salaryDao.findById(1L).orElseThrow(() -> new EntityNotFoundException("Salary Not Found"));
        Budget budget = new Budget(2200, "Rent", true, salary);
        budgetDao.save(budget);

        Budget budget2 = new Budget(600, "STC Bails", true, salary);
        budgetDao.save(budget2);

        Budget budget3 = new Budget(3075, "Bank Loan", false, salary);
        budgetDao.save(budget3);
    }
    /* Ends User Budget Operations */

    /* Begin User Category Operations */
    public static void categoryOperations(CategoryDao categoryDao, BudgetDao budgetDao) {
        createCategory(categoryDao, budgetDao);
        // updateCategory(categoryDao);
        // deleteCategory(categoryDao);
        // fetchCategories(categoryDao);
    }
    /* Ends User Budget Operations */

    private static void fetchCategories(CategoryDao categoryDao) {
        categoryDao.findAll().forEach(category -> System.out.println(category.toString()));

    }

    private static void deleteCategory(CategoryDao categoryDao) {
        Category category = categoryDao.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("Category Not Found"));
        categoryDao.delete(category);
    }

    private static void updateCategory(CategoryDao categoryDao) {
        Category category = categoryDao.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("Category Not Found"));
        category.setCategoryName("TEST");
        categoryDao.save(category);

    }

    private static void createCategory(CategoryDao categoryDao, BudgetDao budgetDao) {
        Budget budget = budgetDao.findById(2L).orElseThrow(() -> new EntityNotFoundException("Budget Not Found"));
        Category category = new Category("Personal", budget);
        categoryDao.save(category);
    }

}
