package com.haidang.springform.controller;

import com.haidang.springform.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "/create";
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("employee", employee);
        return "/info";
    }
}
