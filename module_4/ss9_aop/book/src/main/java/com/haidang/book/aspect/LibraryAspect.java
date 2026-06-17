package com.haidang.book.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LibraryAspect {

    @AfterReturning(
            "execution(* com.haidang.book.service.BookService.borrow(..))")
    public void borrowLog() {

        System.out.println("BOOK BORROWED");
    }

    @AfterReturning(
            "execution(* com.haidang.book.service.BookService.returnBook(..))")
    public void returnLog() {

        System.out.println("BOOK RETURNED");
    }
}
