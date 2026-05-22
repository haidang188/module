package com.haidang.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @GetMapping("/")
    public String showCalculator() {
        return "index";
    }

    @PostMapping("/calculate")
    public String showCalculator(@RequestParam("firstNumber") double firstNumber,
                                 @RequestParam("secondNumber") double secondNumber,
                                 @RequestParam("operator") String operator,
                                 Model model) {

        double result = 0;
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                result = firstNumber / secondNumber;
                break;


        }
        model.addAttribute("result", result);
        model.addAttribute("operator", operator);
        return "index";
    }
}
