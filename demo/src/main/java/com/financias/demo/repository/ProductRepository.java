package com.financias.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.financias.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
