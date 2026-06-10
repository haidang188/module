package com.haidang.customerphonevalidate.controller;

import com.haidang.customerphonevalidate.model.Phone;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PhoneController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("phone", new Phone());
        return "index";
    }

    @PostMapping("/")
    public String checkValidation(@Valid @ModelAttribute("phone") Phone phone, BindingResult bindingResult, Model model) {
        new Phone().validate(phone, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "index";
        } else {
            model.addAttribute("phone", phone);
            return "result";
        }

    }
}
