package com.haidang.productmanagement.repository.ProductRepository;

import com.haidang.productmanagement.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll(int limit, int offset);
    List<Product> search(String keyword);
    Product findById(int id);
    void insert(Product product);
    void update(Product product);
    void delete(int id);
    List<Product> findByCategory(int categoryId);
}
