package onlineshop.service;

import lombok.AllArgsConstructor;
import onlineshop.model.Product;
import onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleProductService implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getProductId());
        Product oldProduct = optionalProduct.orElseThrow(() -> new RuntimeException("Product not found"));
        oldProduct.setName(product.getName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setQuantityStock(product.getQuantityStock());
        productRepository.save(oldProduct);
    }

    @Override
    public void deleteById(int id) {
        productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.deleteById(id);
    }
}
