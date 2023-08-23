package com.tts.introToSpringBoot.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tts.introToSpringBoot.model.Product;
import com.tts.introToSpringBoot.repository.ProductRepository;

@RestController
@RequestMapping("/v1")
public class controllerV1 {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/test")
	public String test() {
		return "Testing in V1";
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		List<Product> products = productRepository.findAll();		
		return products;
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getProductById(@PathVariable(value="id") Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product;
	}
	
	@GetMapping("/product/{name}")
	public Optional<Product> getProductByProductName(@PathVariable(value="name") String name) {
		Optional<Product> product = productRepository.findByProductName(name);
		return product;
	}
	
	@PostMapping("/products") 
	public void createProduct(@RequestBody Product product) {
		Optional<Product> check = productRepository.findByProductName(product.getProductName());
		
		if (check.isEmpty()) {
			productRepository.save(product);
		}
	}
	
}
