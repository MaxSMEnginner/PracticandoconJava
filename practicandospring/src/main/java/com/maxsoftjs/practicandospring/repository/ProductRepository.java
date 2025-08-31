package com.maxsoftjs.practicandospring.repository;

import com.maxsoftjs.practicandospring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
