package com.haidang.productmanagementorm.service;

import com.haidang.productmanagementorm.model.Product;
import com.haidang.productmanagementorm.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    private final IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Product product) {
    iProductRepository.save(product);
    }

    @Override
    public void delete(int id) {
    iProductRepository.deleteById(id);
    }
}
