package com.example.japineappleapp.controllers;

import com.example.japineappleapp.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.japineappleapp.models.Category;

import java.util.List;
import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CategoryController {
	@Autowired
    private CategoryRepository categoryRepository;
	
	@GetMapping("/categories")
    public ResponseEntity<List<Category>> listaUsers() {
    	try {
            List<Category> categories = new ArrayList<Category>();
            categoryRepository.findAll().forEach(categories::add);
            if(categories.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
