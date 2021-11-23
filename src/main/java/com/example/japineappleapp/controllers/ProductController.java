package com.example.japineappleapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.japineappleapp.models.Product;
import com.example.japineappleapp.repositories.ProductRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")

public class ProductController {
	@Autowired
    private ProductRepository productRepository;
	
    @PostMapping("/products")
    public ResponseEntity<Product> crearProduct(@RequestBody Product product) {
        try {
            Product _product = productRepository.save(product);
            return new ResponseEntity<Product>(_product, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> listaProducts() {
        try {
            List<Product> products = new ArrayList<Product>();
            productRepository.findAll().forEach(products::add);
            if(products.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> consultaProduct(@PathVariable(value="id") Integer id) {
        Optional<Product> productData = productRepository.findById(id);
        if(productData.isPresent()) {
            return new ResponseEntity<>(productData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> actualizaProduct(@PathVariable("id") Integer id, @RequestBody Product product) {
        Optional<Product> productData = productRepository.findById(id);

        if(productData.isPresent()) {
            Product _product = productData.get();
            _product.setName(product.getName());
            _product.setDescription(product.getDescription());
            _product.setCategory(product.getCategory());
            _product.setQuantity(product.getQuantity());
            _product.setUnitPrice(product.getUnitPrice());
            return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> eliminaProduct(@PathVariable(value="id") Integer id) {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
