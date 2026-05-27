package com.haidang.productmanagement.serivce;

import com.haidang.productmanagement.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 18 Pro Max", 5000, "iPhone chất lượng cao", "Apple"));
        products.put(2, new Product(2, "iPhone 17 Pro Max", 4000, "Hiệu năng vượt trội", "Apple"));
        products.put(3, new Product(3, "iPhone 16 Pro Max", 3000, "Camera đỉnh", "Apple"));
        products.put(4, new Product(4, "Samsung S26 Ultra", 8000, "Samsung chất lượng cao", "Samsung"));
        products.put(5, new Product(5, "Samsung A56 5G", 1000, "Hiệu năng đỉnh", "Samsung"));

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
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void delete(int id) {
        products.remove(id);

    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
}
