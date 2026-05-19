package haidang.demo.service;

import haidang.demo.model.Category;
import haidang.demo.repository.CategoryRepository;
import haidang.demo.repository.ICategoryRepository;

import java.util.List;

public class CategoryService implements ICategoryService {

    private ICategoryRepository categoryRepository = new CategoryRepository();

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}