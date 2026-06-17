package com.haidang.book.repository;

import com.haidang.book.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BorrowBookRepository extends JpaRepository<BorrowBook, Long> {
    Optional<BorrowBook> findByBorrowCode(Integer borrowCode);
}
