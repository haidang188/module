package com.haidang.dictionary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;


@Controller
public class DictionaryController {
    @GetMapping("/")
    public String home() {
        return "index";
    }
    @PostMapping("/translate")
    public String translate(@RequestParam("word") String word, Model model) {
        Map<String, String> dictionary = new HashMap<>();

        dictionary.put("hello", "xin chào");
        dictionary.put("cat", "con mèo");
        dictionary.put("dog", "con chó");
        dictionary.put("books", "quyển sách");
        dictionary.put("computer", "máy tính");

        String result = dictionary.get(word.toLowerCase());

        if (result == null) {
            result = "Không tìm thấy";
        }
        model.addAttribute("word", word);
        model.addAttribute("result", result);
        return "result";
    }

}
