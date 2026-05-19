package com.haidang.currency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @PostMapping("/convert")
    public String convert(
            @RequestParam("rate") double rate,
            @RequestParam("usd") double usd,
            Model model
    ) {
        double vnd = rate * usd;
        model.addAttribute("result", vnd);
        return "result";
    }
}
