package com.haidang.productmanagement.service.CategoryService;

import com.haidang.productmanagement.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(int id);

    void insert(Category category);

    void update(Category category);

    void delete(int id);
}
