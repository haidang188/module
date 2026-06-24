package com.haidang.blog.service;

import com.haidang.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void delete(Long id);
}
