package com.haidang.currency.controller;

import com.haidang.currency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @PostMapping("/convert")
    public String convert(
            @RequestParam("rate") double rate,
            @RequestParam("usd") double usd,
            Model model
    ) {
        double vnd = currencyService.convertUSDtoVND(rate, usd);
        model.addAttribute("result", vnd);
        return "result";
    }
}
