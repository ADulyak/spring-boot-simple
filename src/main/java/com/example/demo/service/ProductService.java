package com.example.demo.service;

import com.example.demo.model.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductService {

    private Map<Long, Product> productMap = new HashMap<>();

    ProductService() {
        Product product = new Product(1L, "Avocado", 10.0);
        Product product2 = new Product(2L, "Pineapple", 18.5);
        Product product3 = new Product(3L, "Ginger", 1.0);

        productMap.put(product.getId(), product);
        productMap.put(product2.getId(), product2);
        productMap.put(product3.getId(), product3);
    }

    public List<Product> getAll() {
        return new ArrayList<>(productMap.values());
    }

    public void add(Product product) {
        if (product.getId() == null) {
            long id = productMap.size() + 1;
            product.setId(id);
            productMap.put(id, product);
        } else {
            productMap.put(product.getId(), product);
        }
    }

    public Product findById(Long id) {
        Product product = productMap.get(id);
        return product;
    }

    public void remove(Product product) {
        if (product.getId() != null) {
            productMap.remove(product.getId());
        }
    }
}
