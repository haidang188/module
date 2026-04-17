package com.haidang.productmanagement.service.ProductService;

import com.haidang.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll(int limit, int offset);

    List<Product> search(String keyword);

    Product findById(int id);

    void insert(Product product);

    void update(Product product);

    void delete(int id);

    List<Product> findByCategory(int categoryId);
}
