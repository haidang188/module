package com.haidang.book.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VisitorAspect {

    private static int count = 0;

    @Before(
            "execution(* com.haidang.book.controller.BookController.*(..))")
    public void countVisitor() {

        count++;

        System.out.println("Visitor: " + count);
    }
}
