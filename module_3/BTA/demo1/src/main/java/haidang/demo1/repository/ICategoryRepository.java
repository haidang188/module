package haidang.demo1.repository;

import haidang.demo1.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
    Category findById(int id);
    void insert(Category category);
    void update(Category category);
    void delete(int id);

}
