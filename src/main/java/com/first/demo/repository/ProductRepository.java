package com.first.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.first.demo.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
