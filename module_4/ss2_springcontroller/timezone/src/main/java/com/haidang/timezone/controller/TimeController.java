package com.haidang.timezone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/")
    public String home(Model model) {
        return "redirect:/world-clock";
    }

    @GetMapping("/world-clock")
    public String getTimeByTimeZone(Model model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        Date date = new Date();
        TimeZone localTimeZone = TimeZone.getDefault();
        TimeZone tagetTimeZone = TimeZone.getTimeZone(city);
        long timeDifference = tagetTimeZone.getRawOffset() - localTimeZone.getRawOffset();
        long tagetTimeInMilliSeconds = date.getTime() + timeDifference;
        date.setTime(tagetTimeInMilliSeconds);


        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
