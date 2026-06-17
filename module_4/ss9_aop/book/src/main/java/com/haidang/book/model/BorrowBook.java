package com.haidang.book.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer borrowCode;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
