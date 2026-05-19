package haidang.demo1.service;

import haidang.demo1.model.Category;

import java.util.List;

public class CategoryService implements ICategoryService {
    private CategoryService categoryService = new CategoryService();

    @Override
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryService.findById(id);
    }

    @Override
    public void insert(Category category) {
        categoryService.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryService.update(category);
    }

    @Override
    public void delete(int id) {
        categoryService.delete(id);
    }
}
