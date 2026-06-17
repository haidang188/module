package com.haidang.book.service;

import com.haidang.book.exception.OutOfBookException;
import com.haidang.book.exception.WrongCodeException;
import com.haidang.book.model.Book;
import com.haidang.book.model.BorrowBook;
import com.haidang.book.repository.BookRepository;
import com.haidang.book.repository.BorrowBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowBookRepository borrowBookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    @Override
    public Integer borrow(Long id) {
        Book book = findById(id);
        if (book.getQuantity() <= 0) {
            throw new OutOfBookException();
        }
        book.setQuantity(book.getQuantity() - 1);
        bookRepository.save(book);

        Integer code = 10000 + new Random().nextInt(90000);
        BorrowBook borrowBook = new BorrowBook();
        borrowBook.setBorrowCode(code);
        borrowBook.setBook(book);

        borrowBookRepository.save(borrowBook);
        return code;
    }

    @Override
    public void returnBook(Integer code) {
        BorrowBook borrowBook = borrowBookRepository.findByBorrowCode(code).orElseThrow(WrongCodeException::new);
        Book book = borrowBook.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);
        borrowBookRepository.delete(borrowBook);

    }
}
