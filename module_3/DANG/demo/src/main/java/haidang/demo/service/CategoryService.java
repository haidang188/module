package haidang.demo.service;

import haidang.demo.model.Category;
import haidang.demo.repository.CategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService{
    private CategoryRepository categoryRepository = new CategoryRepository();
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void insert(Category category) {
        categoryRepository.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.update(category);
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }
}
