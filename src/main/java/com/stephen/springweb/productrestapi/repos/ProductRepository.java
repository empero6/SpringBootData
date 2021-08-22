package com.stephen.springweb.productrestapi.repos;

import java.util.List;

import com.stephen.springweb.productrestapi.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();
    
}
