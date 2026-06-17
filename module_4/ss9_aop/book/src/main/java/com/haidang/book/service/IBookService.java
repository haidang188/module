package com.haidang.book.service;

import com.haidang.book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Long id);
    Integer borrow(Long id);
    void returnBook(Integer code);
}
