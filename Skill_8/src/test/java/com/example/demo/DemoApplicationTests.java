package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ProductRepository repository;

    @Test
    void contextLoads() {
        assertThat(repository).isNotNull();
    }

    // Task 2a – findByCategory
    @Test
    void testFindByCategory() {
        List<Product> result = repository.findByCategory("Electronics");
        assertThat(result).isNotEmpty();
        result.forEach(p -> assertThat(p.getCategory()).isEqualTo("Electronics"));
    }

    // Task 2b – findByPriceBetween
    @Test
    void testFindByPriceBetween() {
        List<Product> result = repository.findByPriceBetween(100, 500);
        assertThat(result).isNotEmpty();
        result.forEach(p -> {
            assertThat(p.getPrice()).isGreaterThanOrEqualTo(100);
            assertThat(p.getPrice()).isLessThanOrEqualTo(500);
        });
    }

    // Task 3a – JPQL sort by price
    @Test
    void testFindAllSortedByPrice() {
        List<Product> sorted = repository.findAllSortedByPrice();
        for (int i = 0; i < sorted.size() - 1; i++) {
            assertThat(sorted.get(i).getPrice())
                    .isLessThanOrEqualTo(sorted.get(i + 1).getPrice());
        }
    }

    // Task 3b – JPQL expensive products
    @Test
    void testFindExpensiveProducts() {
        List<Product> result = repository.findExpensiveProducts(500);
        assertThat(result).isNotEmpty();
        result.forEach(p -> assertThat(p.getPrice()).isGreaterThan(500));
    }

    // Task 3c – JPQL by category
    @Test
    void testFindProductsByCategoryJPQL() {
        List<Product> result = repository.findProductsByCategoryJPQL("Footwear");
        assertThat(result).isNotEmpty();
        result.forEach(p -> assertThat(p.getCategory()).isEqualTo("Footwear"));
    }
}
