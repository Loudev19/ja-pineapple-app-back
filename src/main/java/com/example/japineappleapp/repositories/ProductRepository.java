package com.example.japineappleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.japineappleapp.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	public Product findByName(String name);
}
