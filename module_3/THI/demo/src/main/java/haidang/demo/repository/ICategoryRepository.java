package haidang.demo.repository;

import haidang.demo.model.Category;

import java.util.List;

public interface ICategoryRepository {
    List<Category> findAll();
}
