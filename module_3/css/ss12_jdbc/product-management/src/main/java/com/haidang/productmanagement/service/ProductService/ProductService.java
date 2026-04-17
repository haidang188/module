package com.haidang.productmanagement.service.ProductService;

import com.haidang.productmanagement.model.Product;
import com.haidang.productmanagement.repository.ProductRepository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private ProductRepository productRepo = new ProductRepository();

    @Override
    public List<Product> findAll(int limit, int offset) {
        return productRepo.findAll(limit, offset);
    }

    @Override
    public List<Product> search(String keyword) {
        return productRepo.search(keyword);
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public void insert(Product product) {
        // có thể validate ở đây
        productRepo.insert(product);
    }

    @Override
    public void update(Product product) {
        productRepo.update(product);
    }

    @Override
    public void delete(int id) {
        productRepo.delete(id);
    }

    @Override
    public List<Product> findByCategory(int categoryId) {
        return productRepo.findByCategory(categoryId);
    }
}
