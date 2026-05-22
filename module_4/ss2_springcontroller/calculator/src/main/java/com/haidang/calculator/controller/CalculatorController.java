package com.haidang.calculator.controller;

import com.haidang.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String showCalculator() {
        return "index";
    }

    @PostMapping("/calculate")
    public String showCalculator(@RequestParam("firstNumber") double firstNumber,
                                 @RequestParam("secondNumber") double secondNumber,
                                 @RequestParam("operator") String operator,
                                 Model model) {

        double result = calculatorService.calculate(firstNumber, secondNumber, operator);
        
        model.addAttribute("result", result);
        model.addAttribute("operator", operator);
        return "index";
    }
}
