package com.haidang.blog.service;

import com.haidang.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Long id);
    void save(Category category);
    void delete(Long id);
}
