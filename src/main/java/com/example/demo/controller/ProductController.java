package com.example.demo.controller;

import com.example.demo.CreateProductRequest;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductController {

    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public Product readProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequest request) {
        Product product1 = new Product();
        product1.setPrice(request.getPrice());
        product1.setName(request.getName());
        productService.add(product1);
        return ResponseEntity.ok(product1);
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody CreateProductRequest request) {
        Product product1 = productService.findById(request.getId());
        product1.setPrice(request.getPrice());
        product1.setName(request.getName());
        productService.add(product1);
        return ResponseEntity.ok(product1);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        Product product = productService.findById(id);
        productService.remove(product);
    }
}
