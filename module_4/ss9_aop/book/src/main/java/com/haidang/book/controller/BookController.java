package com.haidang.book.controller;

import com.haidang.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "list";
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable Long id, Model model) {
        Integer code = bookService.borrow(id);
        model.addAttribute("code", code);
        return "success";
    }

    @GetMapping("/return")
    public String showReturnForm() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Integer code) {
        bookService.returnBook(code);
        return "redirect:/";
    }
}
