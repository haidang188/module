package com.haidang.book.exception;

public class OutOfBookException extends RuntimeException {
    public OutOfBookException() {
        super("Book out of stock");
    }
}
