package com.rayan.salarytracker.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.service.SalaryService;

@Controller
@RequestMapping("salaries")
public class SalaryController {

    private SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/index")
    public String salaries(Model model) {
        List<Salary> salaryList = salaryService.fetchSalaries();
        model.addAttribute("salaryList", salaryList);
        return "salary-views/salaries";
    }
}
