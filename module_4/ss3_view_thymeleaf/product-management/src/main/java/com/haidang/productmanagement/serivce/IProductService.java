package com.haidang.productmanagement.serivce;

import com.haidang.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void update(int id,Product product);
    void delete(int id);
    List<Product> findByName(String name);
}
