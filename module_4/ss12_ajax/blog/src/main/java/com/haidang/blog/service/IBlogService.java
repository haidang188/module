package com.haidang.blog.service;

import com.haidang.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void delete(Long id);
    List<Blog> search(String keyword);
    Page<Blog> findAll(Pageable pageable);
}
