package com.haidang.book.exception;

public class WrongCodeException extends RuntimeException{
    public WrongCodeException() {
        super("Wrong borrow code");
    }
}

