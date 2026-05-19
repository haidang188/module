package haidang.demo1.service;

import haidang.demo1.model.Product;
import haidang.demo1.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> search(String keyword) {
        return productRepository.search(keyword);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void insert(Product product) {
    productRepository.insert(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);

    }

    @Override
    public void delete(int id) {
        productRepository.delete(id);

    }
}
