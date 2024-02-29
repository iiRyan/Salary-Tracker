package com.rayan.salarytracker.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rayan.salarytracker.entity.Budget;
import com.rayan.salarytracker.entity.BudgetSummary;
import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.service.BudgetService;
import com.rayan.salarytracker.service.BudgetSummaryService;
import com.rayan.salarytracker.service.SalaryService;

@Controller
@RequestMapping("budgets")
public class BudgetController {

    private BudgetService budgetService;
    private SalaryService salaryService;
    private BudgetSummaryService budgetSummaryService;
    public final String path = "budgets-views";

    public BudgetController(BudgetService budgetService, SalaryService salaryService,
            BudgetSummaryService budgetSummaryService) {
        this.budgetService = budgetService;
        this.salaryService = salaryService;
        this.budgetSummaryService = budgetSummaryService;
    }

    @GetMapping("/index")
    public String budgets(Long salaryId, Model model) {
        List<Budget> budgetList = budgetService.getBudgetsBySalaryId(salaryId);
        Salary salary = salaryService.loadSalaryById(salaryId);
        BudgetSummary budgetSummary = budgetSummaryService.findAllBySalaryId(salaryId);

        model.addAttribute("budgets", budgetList);
        model.addAttribute("salary", salary);
        model.addAttribute("budgetSummary", budgetSummary);
        return path + "/budgets";
    }

    @PostMapping("/save")
    public String saveBudget(@RequestParam("salaryId") Long salaryId, Budget budget) {

        // Set the Salary object for the Budget
        Salary salary = salaryService.loadSalaryById(salaryId);
        budget.setSalary(salary);

        budgetService.createOrUpdateBudget(budget);
        return "redirect:/budgets/index?salaryId=" + salaryId;
    }

    @GetMapping("/delete")
    public String delete(Long budgetId, Long salaryId) {
        budgetService.removeBudget(budgetId);
        return "redirect:/budgets/index?salaryId=" + salaryId;
    }
}
