package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // Task 4a – GET /products/category/{category}
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category) {
        return repository.findByCategory(category);
    }

    // Task 4b – GET /products/filter?min=&max=
    @GetMapping("/filter")
    public List<Product> getByPriceRange(@RequestParam double min,
                                         @RequestParam double max) {
        return repository.findByPriceBetween(min, max);
    }

    // Task 4c – GET /products/sorted  (JPQL – sort by price ASC)
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return repository.findAllSortedByPrice();
    }

    // Task 4d – GET /products/expensive/{price}  (JPQL – above given price)
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return repository.findExpensiveProducts(price);
    }
}
