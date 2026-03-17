package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // ── Task 2 – Derived Query Methods ────────────────────────────────────
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // ── Task 3 – JPQL Queries using @Query ────────────────────────────────

    // 3a. Sort products by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> findAllSortedByPrice();

    // 3b. Fetch products above a price value
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findExpensiveProducts(@Param("price") double price);

    // 3c. Fetch products by category
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> findProductsByCategoryJPQL(@Param("category") String category);
}
