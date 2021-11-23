package com.example.japineappleapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.japineappleapp.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
    public Category findByName(String name);    
}
