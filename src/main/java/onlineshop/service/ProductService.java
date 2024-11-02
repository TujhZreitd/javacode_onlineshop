package onlineshop.service;

import onlineshop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    Product create(Product product);
    void update(Product product);
    void deleteById(int id);
}
