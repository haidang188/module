package com.haidang.productmanagement.service.CategoryService;

import com.haidang.productmanagement.model.Category;
import com.haidang.productmanagement.repository.CategoryRepository.CategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService {
    private CategoryRepository categoryRepo = new CategoryRepository();

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public void insert(Category category) {
        categoryRepo.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryRepo.update(category);
    }

    @Override
    public void delete(int id) {
        categoryRepo.delete(id);
    }
}
