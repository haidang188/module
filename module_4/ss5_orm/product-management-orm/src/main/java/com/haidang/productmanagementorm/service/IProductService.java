package com.haidang.productmanagementorm.service;

import com.haidang.productmanagementorm.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void delete(int id);
}
