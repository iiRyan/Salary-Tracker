package com.rayan.salarytracker.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rayan.salarytracker.entity.Salary;
import com.rayan.salarytracker.entity.User;
import com.rayan.salarytracker.service.SalaryService;
import com.rayan.salarytracker.service.UserService;

@Controller
@RequestMapping("salaries")
public class SalaryController {

    public final String path = "salary-views";
    private SalaryService salaryService;
    private UserService userService;

    public SalaryController(SalaryService salaryService, UserService userService) {
        this.salaryService = salaryService;
        this.userService = userService;
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
        User user = userService.findByUserId(1L);
        salary.setUser(user);
        salaryService.updateSalary(salary);
        return "redirect:/salaries/index";
    }

    @GetMapping("/delete")
    public String deleteSalary(Long salaryId) {
        salaryService.removeSalary(salaryId);

        return "redirect:/salaries/index";
    }
}
