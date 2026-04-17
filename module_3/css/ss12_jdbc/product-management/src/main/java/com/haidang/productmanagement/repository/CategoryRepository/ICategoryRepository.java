package com.haidang.productmanagement.repository.CategoryRepository;

import com.haidang.productmanagement.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();

    Category findById(int id);

    void insert(Category category);

    void update(Category category);

    void delete(int id);
}
