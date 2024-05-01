package com.rayan.salarytracker.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.service.SalaryService;

@Controller
public class HomeController {

    private SalaryService salaryService;

    public HomeController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping("/about")
    public String about() {
        return "/about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "/contact";
    }

}