package haidang.demo.service;

import haidang.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> search(String keyword);
    Product findById(int id);
    void insert(Product product);
    void update(Product product);
    void delete(int id);
}
