package com.rayan.salarytracker.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.service.SalaryService;

@Controller
@RequestMapping("salaries")
public class SalaryController {

    public final String path = "salary-views";
    private SalaryService salaryService;

    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;

    }

    @GetMapping("/index")
    public String salaries(Model model) {
        List<Salary> salaryList = salaryService.fetchSalaries();
        model.addAttribute("salaryList", salaryList);
        return path + "/salaries";
    }

    @GetMapping("/updateForm")
    public String updateForm(Long salaryId, Model model) {
        Salary theSalary = salaryService.loadSalaryById(salaryId);
        model.addAttribute("salary", theSalary);
        return path + "/update-form";
    }

    @GetMapping("/createForm")
    public String createForm(Model model) {
        List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December");
        model.addAttribute("salary", new Salary());
        model.addAttribute("months", months);
        return path + "/create-form";
    }

    @PostMapping("/save")
    public String save(Salary salary) {
        salaryService.updateSalary(salary);
        return "redirect:/salaries/index";
    }

    @GetMapping("/delete")
    public String deleteSalary(Long salaryId) {
        salaryService.removeSalary(salaryId);

        return "redirect:/salaries/index";
    }
}
