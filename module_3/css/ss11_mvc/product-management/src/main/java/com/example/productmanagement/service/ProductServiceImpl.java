package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 17 Pro Max", 3000000, 1000));
        products.put(2, new Product(2, "iPhone 17 Pro", 2500000, 1000));
        products.put(3, new Product(3, "iPhone 17 Plus", 2000000, 1000));
        products.put(4, new Product(4, "iPhone 17", 1800000, 1000));
        products.put(5, new Product(5, "iPhone 16 Pro Max", 2500000, 1000));
        products.put(6, new Product(6, "iPhone 16 Pro", 2200000, 1000));

    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);

    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }
}
