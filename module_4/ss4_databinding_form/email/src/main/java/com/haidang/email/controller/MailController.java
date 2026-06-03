package com.haidang.email.controller;

import com.haidang.email.model.Mail;

import com.haidang.email.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private MailService mailService;

    @GetMapping
    public String showForm(Model model) {

        Mail mail = mailService.getMail();

        model.addAttribute("mail", mail);

        return "/index";
    }

    @PostMapping("/update")
    public String updateMail(
            @ModelAttribute("mail") Mail mail) {

        mailService.updateMail(mail);

        return "redirect:/mail";
    }
}
