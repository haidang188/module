package com.haidang.book.advice;

import com.haidang.book.exception.OutOfBookException;
import com.haidang.book.exception.WrongCodeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OutOfBookException.class)
    public String outOfBook(Model model) {

        model.addAttribute("message",
                "Sách đã hết");

        return "error-book";
    }

    @ExceptionHandler(WrongCodeException.class)
    public String wrongCode(Model model) {

        model.addAttribute("message",
                "Mã mượn không tồn tại");

        return "error-code";
    }
}
