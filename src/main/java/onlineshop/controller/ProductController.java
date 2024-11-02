package onlineshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import onlineshop.model.Product;
import onlineshop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ObjectMapper objectMapper;

    @GetMapping
    public String findAll() throws Exception {
        String json = objectMapper.writeValueAsString(productService.findAll());
        return json;
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id) throws Exception {
        String json = objectMapper.writeValueAsString(productService.findById(id));
        return json;
    }

    @PostMapping
    public String createNewProduct(@RequestBody String json) throws Exception {
        Product product = objectMapper.readValue(json, Product.class);
        return objectMapper.writeValueAsString(productService.create(product));
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody String json) throws Exception {
        Product product = objectMapper.readValue(json, Product.class);
        product.setProductId(id);
        productService.update(product);
        return objectMapper.writeValueAsString(productService.findById(product.getProductId()));
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id, @RequestBody String json) throws Exception {
        Product product = objectMapper.readValue(json, Product.class);
        product.setProductId(id);
        productService.deleteById(product.getProductId());
        return objectMapper.writeValueAsString(ResponseEntity.ok("Operation complete"));
    }
}
