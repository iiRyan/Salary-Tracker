package com.rayan.salarytracker.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rayan.salarytracker.entity.Budget;
import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.service.BudgetService;
import com.rayan.salarytracker.service.SalaryService;

@Controller
@RequestMapping("budgets")
public class BudgetController {

    private BudgetService budgetService;
    private SalaryService salaryService;
    public final String path = "budgets-views";

    public BudgetController(BudgetService budgetService, SalaryService salaryService) {
        this.budgetService = budgetService;
        this.salaryService = salaryService;
    }

    @GetMapping("/index")
    public String budgets(Long salaryId, Model model) {
        List<Budget> budgetList = budgetService.getBudgetsBySalaryId(salaryId);
        Salary salary = salaryService.loadSalaryById(salaryId);

        model.addAttribute("budgets", budgetList);
        model.addAttribute("salary", salary);
        return path + "/budgets";
    }
}
